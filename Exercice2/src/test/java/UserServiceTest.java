import org.example.UserService;
import org.example.Utilisateur;
import org.example.UtilisateurApi;
import org.example.ServiceException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.lenient;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceTest {
    @Mock
    private UtilisateurApi utilisateurApiMock;
    @Test
    public void testCreerUtilisateur() throws ServiceException{
// Création d'un nouvel utilisateur
        Utilisateur utilisateur = new Utilisateur("Jean", "Dupont","jeandupont@email.com");
// TODO : Configuration du comportement du mock, utiliser la directive « when » avec sa méthode « thenReturn »
        lenient().doNothing().when(utilisateurApiMock).creerUtilisateur(utilisateur);
// ...
// TODO : Création du service avec le mock
        UserService userService = new UserService(utilisateurApiMock);
// TODO : Appel de la méthode à tester
        userService.creerUtilisateur(utilisateur);
        //********Exercice 03*****
        Mockito.doThrow(new ServiceException(("Echec de la création de l'utilisateur"))).when(utilisateurApiMock).creerUtilisateur(utilisateur);
// TODO : Vérification de l'appel à l'API
        Mockito.verify(utilisateurApiMock, Mockito.times(1)).creerUtilisateur(utilisateur);

       Mockito.when(utilisateurApiMock).thenReturn(true);
// Définition d'un ID fictif
        int idUtilisateur = 123;
// TODO: Configuration du mock pour renvoyer l'ID
// Appel de la méthode à tester
        userService.creerUtilisateur(utilisateur);
// TODO: Vérification de l'ID de l'utilisateur

    }
}