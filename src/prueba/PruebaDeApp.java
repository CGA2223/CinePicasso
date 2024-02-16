package prueba;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

@RunWith(JUnit4.class)
public class PruebaDeApp {

    @Test
    public void pruebaDeCreacionDeUsuarioYInicioDeSesion() {
        // Configura el driver de Selenium (en este caso, para Chrome)
        System.setProperty("webdriver.chrome.driver", "ruta/al/driver/chromedriver");
        WebDriver driver = new ChromeDriver();

        // Paso 1: Abre la aplicación en Eclipse
        driver.get("http://localhost:puerto/tu_app");

        // Espera unos segundos para que se cargue la página
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Paso 2: Haz clic en el botón "Crear nuevo usuario"
        WebElement botonCrearUsuario = driver.findElement(By.id("btnCrearUsuario"));
        botonCrearUsuario.click();

        // Espera unos segundos para que se cargue la página de creación de usuario
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Paso 3: Rellena los campos de texto con información válida
        WebElement nombre = driver.findElement(By.id("txtNombre"));
        nombre.sendKeys("Juan Perez");

        WebElement fechaNacimiento = driver.findElement(By.id("txtFechaDeNacimiento"));
        fechaNacimiento.sendKeys("1990-01-01");

        WebElement genero = driver.findElement(By.id("txtGenero"));
        genero.sendKeys("Masculino");

        WebElement correo = driver.findElement(By.id("txtCorreo"));
        correo.sendKeys("juan.perez@example.com");

        WebElement contrasena = driver.findElement(By.id("txtContrasena"));
        contrasena.sendKeys("contraseña");

        WebElement confirmarContrasena = driver.findElement(By.id("txtConfirmarContrasena"));
        confirmarContrasena.sendKeys("contraseña");

        // Paso 4: Selecciona una opción de la combobox
        WebElement comboBox = driver.findElement(By.id("cboxGusto"));
        comboBox.sendKeys("Segunda Opción");

        // Paso 5: Haz clic en el botón "Crear usuario"
        WebElement botonCrearUsuarioFinal = driver.findElement(By.id("btnCrearUsuario"));
        botonCrearUsuarioFinal.click();

        // Espera unos segundos para que se complete la creación del usuario
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Paso 6: Vuelve a la página de inicio de sesión
        WebElement botonVolverALogin = driver.findElement(By.id("btnVolverALogin"));
        botonVolverALogin.click();

        // Espera unos segundos para que se cargue la página de inicio de sesión
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Paso 7: Introduce el usuario y contraseña creados
        WebElement correoLogin = driver.findElement(By.id("txtCorreo"));
        correoLogin.sendKeys("juan.perez@example.com");

        WebElement contrasenaLogin = driver.findElement(By.id("txtContrasena"));
        contrasenaLogin.sendKeys("contraseña");

        // Paso 8: Haz clic en el botón "Iniciar sesión"
        WebElement botonIniciarSesion = driver.findElement(By.id("btnCrearUsuario1"));
        botonIniciarSesion.click();

        // Espera unos segundos para que se complete el inicio de sesión
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Cierra el navegador al finalizar la prueba
        driver.quit();
    }
}