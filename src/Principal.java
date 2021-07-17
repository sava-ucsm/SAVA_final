
public class Principal{
	
	public static void main(String[] args) {
		Mapa are= new Mapa();
		are.insertVertex("Zamacola",180,70);
		are.insertVertex("Cayma",290,20);
		are.insertVertex("3",220,160); //punto de union
		are.insertVertex("Yanahuara",240,260);
		are.insertVertex("Cercado",320,320);
		are.insertVertex("Miraflores",430,200);
		are.insertVertex("Alto Selva Alegre",390,130);
		are.insertVertex("Paucarpata",600,360);
		are.insertVertex("9",470,490);
		are.insertVertex("Sabandia",570,530);
		are.insertVertex("Jacobo Hunter",240,500);
		are.insertVertex("Sachaca",140,340);
		are.insertVertex("13",140,490); //punto de union
		are.insertVertex("Tiabaya",50,450);
		are.insertEdgeWeight("Zamacola", "Cayma",3f);
		are.insertEdgeWeight("Zamacola", "3",2.5f);
		are.insertEdgeWeight("Cayma", "Yanahuara",6f);
		are.insertEdgeWeight("3", "Yanahuara",2.57f);
		are.insertEdgeWeight("3", "Miraflores",5.3f);
		are.insertEdgeWeight("3", "Alto Selva Alegre",3.19f);
		are.insertEdgeWeight("Yanahuara", "Cercado",2.3f);
		are.insertEdgeWeight("Yanahuara", "Sachaca",3.14f);
		are.insertEdgeWeight("Cercado", "Miraflores",3);
		are.insertEdgeWeight("Cercado", "Sachaca",4.36f);
		are.insertEdgeWeight("Cercado", "9",5.27f);
		are.insertEdgeWeight("Cercado", "Jacobo Hunter",4.66f);
		are.insertEdgeWeight("Cercado", "13",5.79f);
		are.insertEdgeWeight("Cercado", "Paucarpata",6.62f);
		are.insertEdgeWeight("Miraflores", "Alto Selva Alegre",2.11f);
		are.insertEdgeWeight("Miraflores", "Paucarpata",5.45f);
		are.insertEdgeWeight("Paucarpata", "9",6.72f);
		are.insertEdgeWeight("9", "Jacobo Hunter",5.21f);
		are.insertEdgeWeight("9", "Sabandia",2.89f);
		are.insertEdgeWeight("Sachaca", "13",3.61f);
		are.insertEdgeWeight("13", "Tiabaya",2.52f);;
		//are.shortPath("Tiabaya", "Sabandia");
		
		
		ContenedorLocales listaLocales=new ContenedorLocales();		
	
		
		listaLocales.registrarNuevoLocal(10, new Local(1,"Sede Zamacola",new Direccion("Zamacola","Arequipa")));
		listaLocales.registrarNuevoLocal(13, new Local(1,"Sede Cayma",new Direccion("Cayma","Arequipa")));
		listaLocales.registrarNuevoLocal(16, new Local(1,"Sede Yanahuara",new Direccion("Yanahuara","Arequipa")));
		listaLocales.registrarNuevoLocal(19, new Local(1,"Sede Cercado",new Direccion("Cercado","Arequipa")));
		listaLocales.registrarNuevoLocal(21, new Local(1,"Sede Miraflores",new Direccion("Miraflores","Arequipa")));
		listaLocales.registrarNuevoLocal(24, new Local(1,"Sede Alto Selva Alegre",new Direccion("Alto Selva Alegre","Arequipa")));
		listaLocales.registrarNuevoLocal(27, new Local(1,"Sede Paucarpata",new Direccion("Paucarpata","Arequipa")));
		listaLocales.registrarNuevoLocal(30, new Local(1,"Sede Sabandia",new Direccion("Sabandia","Arequipa")));
		listaLocales.registrarNuevoLocal(33, new Local(1,"Sede Jacobo Hunter",new Direccion("Jacobo Hunter","Arequipa")));
		listaLocales.registrarNuevoLocal(36, new Local(1,"Sede Sachaca",new Direccion("Sachaca","Arequipa")));
		listaLocales.registrarNuevoLocal(39, new Local(1,"Sede Tiabaya",new Direccion("Tiabaya","Arequipa")));
		

		HashC<PersonalSalud> listaUsuarios = new HashC<PersonalSalud>(10);
		listaUsuarios.insert(1234,new PersonalSalud("Jeremy","Huaringa","70451278","enfermero",1234,"123456","admin"));
		listaUsuarios.insert(1235,new PersonalSalud("Christian","Chili","70418971","enfermero",1235,"123456","normal"));
		Login login1 = new Login(listaLocales,listaUsuarios, are);
		login1.mostrar_interfaz();
		
		
		
		
		
	}
}
