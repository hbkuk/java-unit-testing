package reflection.animal;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class Animal implements Eating {

    public static String CATEGORY = "domestic";
    private String name;

    public Animal(String name) {
        this.name = name;
    }

    protected abstract String getSound();
}
