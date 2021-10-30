//categorias/Habitacion/Clientes/mensajes/reservas
//modelo o entidad
//interfaces
//repositorio
//servicios
//controlador o web



package tutoria.domingo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties
@EntityScan(basePackages = {"tutoria.domingo.modelo"})

public class DomingoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DomingoApplication.class, args);
	}

}
