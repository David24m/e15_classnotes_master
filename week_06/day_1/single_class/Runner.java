class Runner{
  public static void main(String[] args){
    Bear bear = new Bear("Balu");
    bear.setName("Jaguar");

    String name = bear.getName();

    System.out.println(name);
  }
}
