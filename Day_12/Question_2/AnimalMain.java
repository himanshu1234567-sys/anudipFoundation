package Assignment_12;

public class AnimalMain {

	public static void main(String[] args) {
		
        Animal[] animals = new Animal[3];

        animals[0] = new Dog();
        animals[1] = new Cat();
        animals[2] = new Tiger();

        
        for (Animal animal : animals) {
            animal.eat();
            animal.walk();
            animal.makeNoise();
            System.out.println();  
        }
    }
}