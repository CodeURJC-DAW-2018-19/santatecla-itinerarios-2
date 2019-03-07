package daw.itinerary;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import daw.itinerary.unit.*;
import daw.itinerary.user.UserRepository;
import daw.itinerary.user.User;
import daw.itinerary.content.Content;
import daw.itinerary.content.ContentRepository;
import daw.itinerary.itineraries.*;

@Component
public class DatabaseInitializer {

	// Here repositories from database
	@Autowired
	private UnitRepository unitRepo;
	
	@Autowired
	private ContentRepository contentRepo;

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private ItineraryRepository itineraryRepo;

	@PostConstruct
	public void init() {
			Content exampleContent = new Content("¿Para qué?","lus semper vitae. Sed auctor placerat viverra. Ut a tellus vitae sapien pellentesque elementu");
			Unit unit1 = new Unit(1, "Javascript");
			Unit unit3 = new Unit(3, "CERN");
			Unit unit4 = new Unit(4, "Tim Berners Lee");
			Unit unit5 = new Unit(5, "Año 1989");
			Unit unit6 = new Unit(6, "Matemáticas");
			Unit unit7 = new Unit(7, "Psicología");
			/*Itinerary and Unit sample initializer */

			unit1.addContent(exampleContent);
			unitRepo.save(unit1);
			unitRepo.save(unit3);
			unitRepo.save(unit4);
			unitRepo.save(unit5);
			unitRepo.save(unit6);
			unitRepo.save(unit7);
			
			itineraryRepo.save(new Itinerary("Primeros pasos", unit1));
			itineraryRepo.save(new Itinerary("Uso avanzado", unit1));
			itineraryRepo.save(new Itinerary("Eventos", unit5));
			itineraryRepo.save(new Itinerary("Cumpleaños de famosos", unit5));
			itineraryRepo.save(new Itinerary("Calendario", unit5));
			itineraryRepo.save(new Itinerary("Historia", unit3));
			itineraryRepo.save(new Itinerary("Principales líneas de investigación", unit3));
			itineraryRepo.save(new Itinerary("Futuros proyectos", unit3));
			itineraryRepo.save(new Itinerary("Datos adicionales", unit3));
			itineraryRepo.save(new Itinerary("Biografía", unit4));
			itineraryRepo.save(new Itinerary("World Wide Web", unit4));
			itineraryRepo.save(new Itinerary("Cálculo diferencial", unit6));
			itineraryRepo.save(new Itinerary("Algoritmos matemáticos", unit6));
			itineraryRepo.save(new Itinerary("Psicobiología", unit7));
			itineraryRepo.save(new Itinerary("Comportamiento humano", unit7));
			itineraryRepo.save(new Itinerary("Psicometría", unit7));
			itineraryRepo.save(new Itinerary("Terapia cognitivo conductual", unit7));
			
			/*Content sample initializer */
			contentRepo.save(exampleContent);

			for(int i = 0; i < 13; i++)
			{
				contentRepo.save(new Content("Title " + i, "Pichulo", unit1));
			}

			contentRepo.save(new Content("¿Qué?","JavaScript es un lenguaje de programación interpretado, dialecto del estándar ECMAScript. Se define como orientado a objetos, ​ basado en prototipos, imperativo, débilmente tipado y dinámico.", unit1));
			contentRepo.save(new Content("Historia","JavaScript fue desarrollado originalmente por Brendan Eich de Netscape con el nombre de Mocha, el cual fue renombrado posteriormente a LiveScript, para finalmente quedar como JavaScript.", unit1));
			contentRepo.save(new Content("¿Qué?","La Organización Europea para la Investigación Nuclear (nombre oficial en francés: Organisation européenne pour la recherche nucléaire),1​ comúnmente conocida por la sigla CERN (Conseil Européen pour la Recherche Nucléaire", unit3));
			contentRepo.save(new Content("¿Cómo?","El CERN se encuentra en Suiza, cerca de Ginebra, y próximo a la frontera con Francia. Cuenta con una serie de aceleradores de partículas entre los que destaca el, ya desmantelado, LEP", unit3));
			contentRepo.save(new Content("Historia","Fundado en 1954 por 12 países europeos, el CERN es hoy en día un modelo de colaboración científica internacional y uno de los centros de investigación más importantes en el mundo.", unit3));
			contentRepo.save(new Content("Premios","El centro fue premiado en 2013 con el Premio Príncipe de Asturias de Investigación Científica y Técnica junto a Peter Higgs, y François Englert.", unit3));
			contentRepo.save(new Content("¿Qué?","Timothy \"Tim\" John Berners-Lee, KBE es un científico de la computación británica, conocido por ser el padre de la World Wide Web", unit4));
			contentRepo.save(new Content("¿Qué?","Este año marca un giro en la historia del mundo por las revoluciones que derrocaron a los estados comunistas de Bloque del Este, son conocidos como las Revoluciones de 1989", unit5));
			contentRepo.save(new Content("Historia","Las matemáticas o la matemática1​ (del latín mathematĭca, y este del griego μαθηματικά, derivado de μάθημα, ‘conocimiento’) es una ciencia formal que, partiendo de axiomas y siguiendo el razonamiento lógico", unit6));
			contentRepo.save(new Content("Aspectos formales","Es muy posible que el arte del cálculo haya sido desarrollado antes incluso que la escritura,14​ relacionado fundamentalmente con la contabilidad y la administración de bienes, el comercio, en la agrimensura y, posteriormente, en la astronomía.", unit6));


			/*User samples*/
			userRepository.save(new User("alumno1", "pass1", "ROLE_USER"));
			userRepository.save(new User("alumno2", "pass2", "ROLE_USER"));
			userRepository.save(new User("profesor", "passprofe", "ROLE_USER", "ROLE_ADMIN"));
	}

}
