// This class sets up the common attributes and methods of all Pets
public abstract class Pet {
  private String name;

  public abstract String classOfAnimal();

  public void setName(String petName) {
    name = petName;
  }

  public String getName() {
    return name;
  }
}
