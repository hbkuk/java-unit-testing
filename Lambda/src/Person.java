public class Person {
    private static final int MAX_AGE = 50;
    private String name;
    private int age;
    
    public Person( String name, int age ) {
        if( isInvalidAge(age) ) {
            throw new RuntimeException("50세 이하만 가입이 가능합니다.");
        }
        this.name = name;
        this.age = age;
    }

    private boolean isInvalidAge(int age) {
        return age > MAX_AGE;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}