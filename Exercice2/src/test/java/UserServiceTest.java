package Exercice2;


import org.example.ServiceException;
import org.example.UserService;
import org.example.Utilisateur;
import org.example.UtilisateurApi;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import static org.mockito.Mockito.*;
@RunWith(MockitoJUnitRunner.class)
public class UserServiceTest {
    @Mock
    private UtilisateurApi utilisateurApiMock;
    @Test
    public void testCreerUtilisateur() throws ServiceException {

        Utilisateur utilisateur = new Utilisateur("Jean", "Dupont","jeandupont@email.com");

        // TODO : Configuration du comportement du mock, utiliser la
        //  directive « when » avec sa méthode « thenReturn »
        when(utilisateurApiMock.creerUtilisateur(utilisateur)).thenReturn(true);

        // TODO : Création du service avec le mock
        UserService userService = new UserService(utilisateurApiMock);

        // TODO : Appel de la méthode à tester
        Boolean result = userService.creerUtilisateur(utilisateur);

        Assert.assertEquals(result , true);

        // TODO : Vérification de l'appel à l'API
        verify(utilisateurApiMock).creerUtilisateur(utilisateur);
    }
}