import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

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
    
    @DisplayName("모든 사람의 이름을 대문자로 변환하여 리스트로 반환하는지 확인")
    @ParameterizedTest
    @ValueSource(strings = {"BK", "DK", "YK", "UK"})
    void 대문자_변환(String upperName) {
        // Given: Person 클래스
        
        // When
        List<String> upperCaseNames = people.stream()
                        .map(person -> person.getName().toUpperCase())
                        .collect(Collectors.toList());
        
        // Then
        assertTrue(upperCaseNames.contains(upperName));
        
    }
}
