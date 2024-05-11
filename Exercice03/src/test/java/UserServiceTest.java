

import org.example.ServiceException;
import org.example.UserService;
import org.example.Utilisateur;
import org.example.UtilisateurApi;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.*;

    @RunWith(MockitoJUnitRunner.class)
    public class UserServiceTest {
        @Mock
        private UtilisateurApi utilisateurApiMock;



        @Test
        public void testscénarios1() throws ServiceException {
            Utilisateur utilisateur = new Utilisateur("Jean", "Dupont", "jeandupont@email.com");
            UserService userService = new UserService(utilisateurApiMock);

            ServiceException serviceException = new ServiceException("Echec de la création de l'utilisateur");
            when(utilisateurApiMock.creerUtilisateur(utilisateur)).thenThrow(serviceException);

            Assert.assertThrows(ServiceException.class, () -> userService.creerUtilisateur(utilisateur));
        }


        @Test
        public void testscénarios2() throws ServiceException {
            Utilisateur utilisateur = new Utilisateur("Jean", "Dupont", "jeandupont@email.com");
            UserService userService = new UserService(utilisateurApiMock);

            ServiceException serviceException = new ServiceException("Echec de la création de l'utilisateur");
            when(utilisateurApiMock.creerUtilisateur(utilisateur)).thenThrow(serviceException);

            verify(utilisateurApiMock , never()).creerUtilisateur(utilisateur);
            Assert.assertThrows(ServiceException.class, () -> userService.creerUtilisateur(utilisateur));

        }

        @Test
        public void testscénarios3() throws ServiceException {
            Utilisateur utilisateur = new Utilisateur("Jean", "Dupont", "jeandupont@email.com");
            UserService userService = new UserService(utilisateurApiMock);

            when(utilisateurApiMock.creerUtilisateur(utilisateur)).thenReturn(true);

            // Définition d'un ID fictif
            int idUtilisateur = 123;
            // TODO: Configuration du mock pour renvoyer l'ID
            // I can continue with my imagination and continue but that's not what you want
            // Appel de la méthode à tester
            userService.creerUtilisateur(utilisateur);
            // TODO: Vérification de l'ID de l'utilisateur
            // I can continue with my imagination and continue but that's not what you want
        }

        public void testscénarios4() throws ServiceException {
            Utilisateur utilisateur = new Utilisateur("Jean", "Dupont", "jeandupont@email.com");
            UserService userService = new UserService(utilisateurApiMock);

            ArgumentCaptor<Utilisateur> argumentCaptor = ArgumentCaptor.forClass(Utilisateur.class);
            when(utilisateurApiMock.creerUtilisateur(any(Utilisateur.class))).thenReturn(true);
            userService.creerUtilisateur(utilisateur);
            Utilisateur utilisateurCapture = argumentCaptor.getValue();

            // TODO : Vérification des arguments capturés, utiliser les getters de
            //  l’objet utilisateurCapture
            Assert.assertEquals("Jean", utilisateurCapture.getName());
            Assert.assertEquals("Dupont", utilisateurCapture.getSecondName());
            Assert.assertEquals("jeandupont@email.com", utilisateurCapture.getEmail());
        }
    }

