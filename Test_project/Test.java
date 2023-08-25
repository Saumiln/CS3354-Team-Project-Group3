public class Test{
   public static void main(String[] args){
      Test1 one = new Test1(1,3);
      Test2 two = new Test2(2,4);
      Test3 three = new Test3('a','b');
      Test4 four = new Test4('h','s');
      one.add();
      two.subtract();
      four.diff();
      three.combine();
   }
}