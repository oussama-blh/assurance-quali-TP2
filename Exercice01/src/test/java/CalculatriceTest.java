import org.example.Calculatrice;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import static org.mockito.Mockito.*;
@RunWith(MockitoJUnitRunner.class)
public class CalculatriceTest {
    @Mock
    private Calculatrice calculatrice;
    @Test
    public void testAdditionner() {
    // Définition du comportement de la méthode "additionner"
        when(calculatrice.additionner(2, 3)).thenReturn(5);
    //TODO : Appel de la méthode à tester
        int result = calculatrice.additionner(2, 3);
    //TODO : Vérification du résultat
        Assertions.assertEquals(5, result);
    //TODO : Vérification que la méthode "additionner" a été appelée
        verify(calculatrice).additionner(2, 3);
    //TODO : Vérification qu'aucune autre méthode n'a été appelée sur
        verifyNoMoreInteractions(calculatrice);
    // TODO : Vérification de l'état de l'objet après l'appel de la
    //méthode "additionner", penser à utiliser la méthode
    //« getState() » de la directive « verify » : // exemple :
        when(calculatrice.getState()).thenReturn(Calculatrice.ENABLE);
        int  s= calculatrice.getState();
        Assert.assertEquals(s , Calculatrice.ENABLE);
        verify(calculatrice).getState();
    }
}
