import org.junit.Test;
import static org.junit.Assert.*;

public class JavaTeste {


    @Test
    public void testeAddition(){
        Calcular calcular = new Calcular ();
        int result  = calcular.add(3,5);
        assertEquals(8,result);


    }

    @Test
    public void testeSubtraction(){
        Calcular calcular = new Calcular();
        int result = calcular.subtract(10,4);
        assertEquals(6, result);

    }



}
