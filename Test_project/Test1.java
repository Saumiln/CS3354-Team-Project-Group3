class Test1{
   private int uno;
   private int dos;
   private int tres = 0;
   
   public Test1(int one, int two) {
      uno = one;
      dos = two;
   }
   
   public Test1(int one, int two, int three) {
      uno = one;
      dos = two;
      tres = three;
   }
   
   public void add(){
      System.out.println(uno + dos + tres);
   }
}
