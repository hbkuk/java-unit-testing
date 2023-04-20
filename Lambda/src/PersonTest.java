import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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
                    .filter(person -> person.getAge() > 25 )
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
                        .filter(person -> person.getAge() >= ageToFilter )
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
                        .isThrownBy(() -> {people.add(new Person("tester1", age));})
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

}
