package lambda;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.assertEquals;

class PersonTest {
    private List<Person> people;

    @BeforeEach
    void setup() {
        people = Arrays.asList(
                new Person("bk", 18),
                new Person("dk", 30),
                new Person("yk", 25),
                new Person("uk", 12));
    }

    @Test
    @DisplayName("특정 나이로 필터링이 되는지 확인:25세 초과")
    void 특정_나이로_필터링() {
        // Given
        int ageToFilter = 25;

        // When
        List<Person> filteredPeople = people.stream()
                .filter(person -> person.getAge() > 25)
                .collect(Collectors.toList());

        // Then
        assertEquals(1, filteredPeople.size());
        assertEquals("dk", filteredPeople.get(0).getName());
    }

    @Test
    @DisplayName("특정 나이로 필터링이 되는지 확인:31세 이상이 최소 1명 이상")
    void 특정_나이로_필터링_31세_이상() {
        // Given
        int ageToFilter = 31;

        // When
        String result = people.stream()
                .filter(person -> person.getAge() >= ageToFilter)
                .map(Person::getName)
                .findFirst()
                .orElse("없음");

        // Then
        assertThat(result).isEqualTo("없음");
    }

    @Test
    @DisplayName("나이(age)가 50세를 초과할 경우 Runtime Exception이 발생하는지 확인")
    void 나이_50세_초과() {
        // Given
        int age = 51;

        // When, Then
        assertThatExceptionOfType(RuntimeException.class)
                .isThrownBy(() -> {
                    people.add(new Person("tester1", age));
                })
                .withMessageMatching("50세 이하만 가입이 가능합니다.");
    }

    @Test
    @DisplayName("특정 이름과 나이로 필터링이 되는지 확인:이름이 d로 시작하면서, 25세 이상")
    void 특정_이름과_나이로_필터링() {
        // Given
        String nameToFilter = "d";
        int age = 25;

        // When
        List<Person> filteredPeople = people.stream()
                .filter(person -> person.getName().startsWith(nameToFilter) &&
                        person.getAge() >= 25)
                .collect(Collectors.toList());

        // Then
        assertThat(filteredPeople).hasSize(1);
        assertThat(filteredPeople.get(0).getName()).isEqualTo("dk");
    }

    @Test
    @DisplayName("나이가 제일 많은 사람의 이름을 출력:다중 최댓값 고려")
    void 나이가_제일_많은_사람() {
        // Given
        List<Person> people = Arrays.asList(
                new Person("o1", 50),
                new Person("o2", 50),
                new Person("o3", 49)
        );

        // When
        int maxAge = people.stream()
                .mapToInt(Person::getAge)
                .max()
                .orElse(0);

        List<String> oldestPeopleNames = people.stream()
                .filter(person -> person.getAge() == maxAge)
                .map(Person::getName)
                .collect(Collectors.toList());
        // Then
        assertThat(oldestPeopleNames).contains("o1", "o2").doesNotContain("o3");
    }

    @Test
    @DisplayName("이름이 가장 긴 사람의 이름을 출력:다중 최댓값 고려")
    void 이름이_가장_긴_사람() {
        //Given
        List<Person> people = Arrays.asList(
                new Person("o1", 50),
                new Person("o2", 50),
                new Person("o3", 49),
                new Person("Constantinople", 20),
                new Person("Christopher", 15)
        );

        //When
        int maxNameLength = people.stream()
                .mapToInt(person -> person.getName().length())
                .max()
                .orElse(0);

        List<String> longestPeopleNames = people.stream()
                .filter(person -> person.getName().length() == maxNameLength)
                .map(Person::getName)
                .collect(Collectors.toList());

        //Then        
        assertThat(longestPeopleNames).contains("Constantinople").doesNotContain("Christopher", "o1", "o2", "o3");
    }

    @Test
    @DisplayName("이름이 가장 짧은 사람의 이름을 출력: 다중 최솟값 고려")
    void testFindShortestName() {
        // Given
        List<Person> people = Arrays.asList(
                new Person("o1", 50),
                new Person("o2", 50),
                new Person("o3", 49),
                new Person("Constantinople", 20),
                new Person("Christopher", 15)
        );

        // When
        Optional<String> shortestName = people.stream()
                .map(Person::getName)
                .min(Comparator.comparingInt(String::length));

        // Then
        assertThat(shortestName.isPresent()).isTrue();
        assertThat(Arrays.asList("o1", "o2", "o3")).contains(shortestName.get()); // shortestName 객체의 값을 검증
        assertThat(shortestName.get()).doesNotContain("Constantinople", "Christopher");
    }
}
