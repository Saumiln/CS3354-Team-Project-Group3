class Test4{
   private char uno;
   private char dos;
   
   public Test4(char one, char two) {
      uno = one;
      dos = two;
   }
   
   public void diff(){
      int tres = (int)uno - (int)dos;
      System.out.println(tres);
   }
}
