import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;


@What
@MyAnno(str = "класс  Main", val = 0)
public class Main {

    @What(description = "Аннотация метода")
    @MyAnno(str = "метод myMeth", val = 1)

    public static void myMeth(@Param(1) String str, @Param(2)int i) {

       Main ob = new Main();
     try {
        Annotation[] annos = ob.getClass().getAnnotations();
         System.out.println("Аннотации класса");
         for(Annotation a: annos){
             System.out.println(a);
         }
         System.out.println();

        Method m = ob.getClass().getMethod("myMeth", String.class, int.class);
        annos = m.getAnnotations();
         System.out.println("Аннотации метода");
         for(Annotation a: annos){
             System.out.println(a);
         }
         System.out.println();

         Annotation[][] anns = m.getParameterAnnotations();

         System.out.println("Аннотации параметрров");
         for(Annotation[] b: anns){
             Annotation[] ann = b;

             for (Annotation a: ann){
                 System.out.println(a);
             }
         }
         System.out.println();
     }
     catch (NullPointerException e) {
         System.out.println(" Don't class");
     }
        catch (NoSuchMethodException e) {
        System.out.println(" Don't method");
     }

    }
    public static void main(String Args[]){
        myMeth("Hello", 13);
    }
}
