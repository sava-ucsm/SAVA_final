

public class Test{

	public static void main(String[] args) {
			Mapa are= new Mapa();
			
			are.insertVertex("Zamacola",180,70);
			are.insertVertex("Cayma",290,20);
			are.insertVertex("3",220,160); //punto de union
			are.insertVertex("Yanahuara",240,260);
			are.insertVertex("Arequipa",320,320);
			are.insertVertex("Miraflores",430,200);
			are.insertVertex("Alto Selva Alegre",390,130);
			are.insertVertex("Paucarpata",600,360);
			are.insertVertex("9",470,490);
			are.insertVertex("Sabandia",570,530);
			are.insertVertex("Jacobo Hunter",240,500);
			are.insertVertex("Sachaca",140,340);
			are.insertVertex("13",140,490); //punto de union
			are.insertVertex("Tiabaya",50,450);
			are.insertEdgeWeight("Zamacola", "Cayma",3);
			are.insertEdgeWeight("Zamacola", "3",2.5f);
			are.insertEdgeWeight("Cayma", "Yanahuara",6);
			are.insertEdgeWeight("3", "Yanahuara",2.57f);
			are.insertEdgeWeight("3", "Miraflores",5.3f);
			are.insertEdgeWeight("3", "Alto Selva Alegre",3.19f);
			are.insertEdgeWeight("Yanahuara", "Arequipa",2.3f);
			are.insertEdgeWeight("Yanahuara", "Sachaca",3.14f);
			are.insertEdgeWeight("Arequipa", "Miraflores",3);
			are.insertEdgeWeight("Arequipa", "Sachaca",4.36f);
			are.insertEdgeWeight("Arequipa", "9",5.27f);
			are.insertEdgeWeight("Arequipa", "Jacobo Hunter",4.66f);
			are.insertEdgeWeight("Arequipa", "13",5.79f);
			are.insertEdgeWeight("Arequipa", "Paucarpata",6.62f);
			are.insertEdgeWeight("Miraflores", "Alto Selva Alegre",2.11f);
			are.insertEdgeWeight("Miraflores", "Paucarpata",5.45f);
			are.insertEdgeWeight("Paucarpata", "9",6.72f);
			are.insertEdgeWeight("9", "Jacobo Hunter",5.21f);
			are.insertEdgeWeight("9", "Sabandia",2.89f);
			are.insertEdgeWeight("Sachaca", "13",3.61f);
			are.insertEdgeWeight("13", "Tiabaya",2.52f);;
			
		are.shortPath("Cayma", "Paucarpata");
			
	}

}
