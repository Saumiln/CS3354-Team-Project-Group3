class Test3{
   private char uno;
   private char dos;
   
   public Test3(char one, char two) {
      uno = one;
      dos = two;
   }
   
   public void combine(){
      String tres = "" + uno + dos;
      System.out.println(tres);
   }
}