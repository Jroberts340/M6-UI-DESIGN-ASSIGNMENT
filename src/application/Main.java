package application;
	
import java.net.URL;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Map.Entry;
import java.util.stream.Collectors;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;


public class Main extends Application 
{
	static Stage aStage = new Stage();
	public static final String BUTTONHOVER = "-fx-text-fill: #FFFFFF;" + "-fx-background-color: #808080;" 
			+ "-fx-font-weight: bold;" + "-fx-font-family: Courier;" + "-fx-font-size: 12pt ;";
	public static final String BUTTONIDLE = "-fx-background-radius: 15px;" + "-fx-background-color: rgb(249,166,25);" 
			+ "-fx-font-weight: bold;" + "-fx-font-family: Courier;" + "-fx-font-size: 12pt ;";
	
	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception{
		aStage = primaryStage;
		
		Button btn = new Button("RESULTS");
		btn.setMinWidth(100);
		btn.setMinHeight(50);
		btn.setFocusTraversable(false);
		btn.setTextFill(Color.rgb(255, 255, 255));
		btn.hoverProperty().addListener((observable,  oldValue,  show) -> {
			if (btn.isHover())
				btn.setStyle(BUTTONHOVER);
			else
				btn.setStyle(BUTTONIDLE);
			
		});
		btn.setStyle("-fx-background-color: rgb(249,166,25);" + "-fx-font-weight: bold;" 
		+ "-fx-font-family: Courier;" + "-fx-font-size: 12pt ;");
		btn.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle (ActionEvent e){			
				try {
					Occurrence oc = new Occurrence();
					oc.start1(Occurrence.bStage);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}	
				aStage.close();
			}
		});
		
		Text l = new Text("''The Raven''");
		l.setFont(Font.font("Arial", FontPosture.ITALIC, 38));
		l.setFill(Color.ORANGE);
		
		Text l1 = new Text(" Word Occurrence");
		l1.setFont(Font.font("Arial", FontPosture.ITALIC, 38));
		l1.setFill(Color.ORANGE);
		
		HBox hb1 = new HBox();
		hb1.setAlignment(Pos.CENTER); 
		hb1.setBackground(new Background(new BackgroundFill(Color.rgb(255, 255, 255),null, null)));
		hb1.getChildren().addAll(l, l1);
		
		VBox hb = new VBox();
		hb.setAlignment(Pos.TOP_CENTER); 
		hb.setSpacing(200);
		hb.setBackground(new Background(new BackgroundFill(Color.rgb(255, 255, 255),null, null)));
		hb.setMaxHeight(400); hb.setMaxWidth(550);
		hb.setMinHeight(400); hb.setMinWidth(550);
		hb.getChildren().addAll(hb1, btn);
		
		Scene scene = new Scene(hb,550,550);
		primaryStage.setScene(scene);
		primaryStage.show();
}

 static class Occurrence extends Application{
	
	static Stage bStage = new Stage();
	
	public void start1 (Stage secStage) throws Exception {
		bStage = secStage;
		
		Text l = new Text("''The Raven''");
		l.setFont(Font.font("Arial", FontPosture.ITALIC, 38));
		l.setFill(Color.ORANGE);
		
		Text l1 = new Text(" Word Occurrence");
		l1.setFont(Font.font("Arial", FontPosture.ITALIC, 38));
		l1.setFill(Color.ORANGE);
		
		Text t = new Text("\nWord: \t Occurrence: ");
		t.setFont(Font.font("Verdana", FontWeight.BOLD, 30));
		t.setFill(Color.ORANGE);
		
		VBox vb3 = new VBox();
		vb3.setAlignment(Pos.CENTER_LEFT); 
		vb3.setMaxHeight(400); vb3.setMaxWidth(175);
		vb3.setMinHeight(400); vb3.setMinWidth(175);
		vb3.setBackground(new Background(new BackgroundFill(Color.rgb(255, 255, 255),null, null)));
		
		VBox vb4 = new VBox();
		vb4.setAlignment(Pos.CENTER_RIGHT); 
		vb4.setMaxHeight(400); vb4.setMaxWidth(170);
		vb4.setMinHeight(400); vb4.setMinWidth(170);
		vb4.setBackground(new Background(new BackgroundFill(Color.rgb(255, 255, 255),null, null)));
		
		HBox hb3 = new HBox();
		hb3.setAlignment(Pos.CENTER_LEFT); 
		hb3.setBackground(new Background(new BackgroundFill(Color.rgb(255, 255, 255),null, null)));
		hb3.getChildren().add(vb3);
		
		HBox hb4 = new HBox();
		hb4.setAlignment(Pos.CENTER_RIGHT); 
		hb4.setBackground(new Background(new BackgroundFill(Color.rgb(255, 255, 255),null, null)));
		hb4.getChildren().add(vb4);
		
		HBox hb5 = new HBox();
		hb5.setAlignment(Pos.CENTER); 
		hb5.setBackground(new Background(new BackgroundFill(Color.rgb(255, 255, 255),null, null)));
		hb5.getChildren().addAll(hb3, hb4);
		
		VBox vb = new VBox();
		vb.setAlignment(Pos.CENTER);
		vb.setBackground(new Background(new BackgroundFill(Color.rgb(255, 255, 255),null, null)));
		vb.setMaxHeight(450); vb.setMaxWidth(450);
		vb.setMinHeight(450); vb.setMinWidth(450);
		vb.getChildren().addAll(t, hb5);
		
		HBox hb1 = new HBox();
		hb1.setAlignment(Pos.CENTER); 
		hb1.setBackground(new Background(new BackgroundFill(Color.rgb(255, 255, 255),null, null)));
		hb1.getChildren().addAll(l, l1);
		
		VBox hb = new VBox();
		hb.setAlignment(Pos.CENTER); 
		hb.setBackground(new Background(new BackgroundFill(Color.rgb(255, 255, 255),null, null)));
		hb.setMaxHeight(550); hb.setMaxWidth(550);
		hb.setMinHeight(550); hb.setMinWidth(550);
		hb.getChildren().addAll(hb1, vb);

		
		Scene scene = new Scene(hb,550,550);
		secStage.setScene(scene);
		
		Text tex1 = new Text();
		Text tex2 = new Text();
		
		HashMap<String, Integer> words = new HashMap<String, Integer>();

		// Pass url through getWords Method and retrieve word count
		getWords("https://www.gutenberg.org/files/1065/1065-h/1065-h.htm", words);

		Map<String, Integer>sortedwords = sortByValue(words);

		for (Entry<String, Integer> word : sortedwords.entrySet()) 
		{	
			tex1 = new Text(word.getKey());
			tex1.setFont(Font.font("Arial", 16));
			tex1.setFill(Color.BLACK);
			vb3.getChildren().add(tex1);
			
			tex2 = new Text(word.getValue() + " times");
			tex2.setFont(Font.font("Arial", 16));
			tex2.setFill(Color.BLACK);
			vb4.getChildren().add(tex2);
		}
		
		secStage.show();
	
}

//public static void m(String[] args) throws Exception
//{	
//	HashMap<String, Integer> words = new HashMap<String, Integer>();
//
//	// Pass url through getWords Method and retrieve word count
//	getWords("https://www.gutenberg.org/files/1065/1065-h/1065-h.htm", words);
//
//	Map<String, Integer>sortedwords = sortByValue(words);
//
//	for (Entry<String, Integer> word : sortedwords.entrySet()) 
//	{	
//		System.out.println("Word: " + word.getKey() + " \t\tTimes Counted: "+ word.getValue());
//	}
//}

void getWords(String url, Map<String, Integer> words) throws Exception
{
	URL website = new URL(url);
	Scanner scan = new Scanner(website.openStream());
	StringBuffer sb = new StringBuffer();
	
	while (scan.hasNext()) {
		sb.append(scan.next());
		sb.append(System.lineSeparator());
	}
	
	
	String res = sb.toString().replaceAll("<[^>]*>", " ").replaceAll("mdash", "\n").replaceAll("\\-", "\n");
	res = res.substring(res.indexOf("The", 1550)-1);
	res = res.substring(0,res.indexOf("!", 6500)+1);
	res = res.replaceAll("\\p{Punct}", "");
	res = res.replaceAll("\\W", "\n");
	res = res.replaceAll("\\s+","\n");
	res = res.trim();
	
	Scanner wc = new Scanner(res);
	
	while (wc.hasNext())
	{
		String word = wc.nextLine();
		word = word.toLowerCase(); 
		// Frequency count variable
		Integer count = words.get(word);

		// If the same word is repeating
		if (count != null) 
		{
			count++;
		}
		else
			// If word never occurred after occurring once, set count as unity
			count = 1;
		words.put(word, count);
	}
	wc.close();
	scan.close();
	
}

///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// Method to sort hashmap by values and limit hashmap output to only 20
public Map<String, Integer> sortByValue(HashMap<String, Integer> wordsort)
{	
	Map<String, Integer> res = wordsort.entrySet().stream()
            .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
            .limit(20)
            .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                    (oldValue, newValue) -> oldValue, LinkedHashMap::new));
	
	return res;		
}

@Override
public void start(Stage primaryStage) throws Exception {
	// TODO Auto-generated method stub
	
}
	}
}

	

