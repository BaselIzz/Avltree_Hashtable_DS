
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

import java.nio.file.Paths;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.FileChooser.ExtensionFilter;

public class Driver extends Application {

	public static void main(String[] args) {
		launch(args);

	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		HashTable<Resident> hResident;
		ComboBox<City> cboCity = new ComboBox<City>();
		cboCity.setPromptText("Select City");
		cboCity.prefWidth(140);
		cboCity.prefHeight(40);
		cboCity.setStyle("-fx-font-size:22");
		AVLTree<City> cities = new AVLTree<City>();
		AnchorPane aPane = new AnchorPane();
		VBox vMain = new VBox();
		Label lbl01 = new Label("DATA STRUCTURE -  COMP 242");
		TextArea txtTree = new TextArea();
		HBox HTree = new HBox();
		HTree.setSpacing(40);
		Label lbl02 = new Label("PROJECT THREE");
		Label lbl03 = new Label("BASEL IZZ  - 1180336");
		Label lbl04 = new Label("SUPERVISOR : DR. MAMOUN NAWAHDA");
		vMain.setSpacing(60.0);
		Button btnMain = new Button("Load File");
		vMain.getChildren().addAll(lbl01, lbl02, lbl03, lbl04, btnMain);
		vMain.setLayoutX(97.0);
		vMain.setLayoutY(33.0);
		vMain.setPrefWidth(800.0);
		vMain.setPrefHeight(500.0);
		lbl01.setPrefWidth(453.0);
		lbl01.setPrefHeight(50.0);
		lbl02.setPrefWidth(453.0);
		lbl02.setPrefHeight(50.0);
		lbl03.setPrefWidth(453.0);
		lbl03.setPrefHeight(50.0);
		lbl04.setPrefWidth(453.0);
		lbl04.setPrefHeight(50.0);
		lbl01.setFont(new Font("Courier New Bold Italic", 22.0));
		lbl02.setFont(new Font("Courier New Bold Italic", 22.0));
		lbl03.setFont(new Font("Courier New Bold Italic", 22.0));
		lbl04.setFont(new Font("Courier New Bold Italic", 22.0));
		btnMain.setFont(new Font("Courier New Bold Italic", 18.0));
		txtTree.setPrefWidth(500);
		txtTree.setPrefHeight(250);
		txtTree.setEditable(false);
		btnMain.setPrefHeight(100.0);
		btnMain.setPrefWidth(462.0);
		aPane.setPrefHeight(700.0);
		aPane.setPrefWidth(800.0);
		aPane.getChildren().add(vMain);
		vMain.setPadding(new Insets(0, 0, 0, 100));
		Scene scene = new Scene(aPane, 800, 600);
		primaryStage.setScene(scene);
		primaryStage.show();
		primaryStage.setResizable(false);
		primaryStage.setTitle("Project 3 ");
		/* AVL Tree MAIN MENU WINDOW */

		AnchorPane commonAVLpane = new AnchorPane();

		commonAVLpane.setPrefHeight(476.0);
		commonAVLpane.setPrefWidth(664.0);
		HBox hSearch = new HBox();
		hSearch.setLayoutX(103.0);
		hSearch.setLayoutY(103.0);
		hSearch.setPrefHeight(100);
		hSearch.setPrefWidth(200);
		hSearch.setSpacing(40.0);
		VBox vSearchL = new VBox();
		vSearchL.setPrefHeight(146.0);
		vSearchL.setPrefWidth(146.0);
		vSearchL.setSpacing(40.0);
		Label lblname = new Label("City Name");
		lblname.setPrefHeight(31.0);
		lblname.setPrefWidth(155.0);
		lblname.setFont(new Font("Modern No. 20", 25.0));
		Label lblFname = new Label("File Name");
		lblFname.setPrefHeight(31.0);
		lblFname.setPrefWidth(155.0);
		lblFname.setFont(new Font("Modern No. 20", 25.0));
		vSearchL.getChildren().addAll(lblname, lblFname);
		VBox vSearchF = new VBox(40);
		vSearchF.setPrefHeight(168.0);
		vSearchF.setPrefWidth(177.0);
		TextField txtCName = new TextField();
		TextField txtFName = new TextField();
		vSearchF.getChildren().addAll(txtCName, txtFName);
		hSearch.getChildren().addAll(vSearchL, vSearchF);
		hSearch.setSpacing(10);
		vSearchF.setPadding(new Insets(8, 0, 0, 0));
		hSearch.setPadding(new Insets(100, 80, 0, 50));
		Button btnCSearch = new Button("Search");
		btnCSearch.setPrefHeight(70.0);
		btnCSearch.setPrefWidth(241.0);
		btnCSearch.setFont(new Font("Modern No. 20", 25.0));
		btnCSearch.setLayoutX(212.0);
		btnCSearch.setLayoutY(368.0);
		commonAVLpane.setBottomAnchor(hSearch, 1.0);
		commonAVLpane.setLeftAnchor(hSearch, 103.0);
		commonAVLpane.setRightAnchor(hSearch, 102.0);
		commonAVLpane.setTopAnchor(hSearch, 79.0);

		commonAVLpane.getChildren().addAll(hSearch, btnCSearch);
		Scene sceneSearch = new Scene(commonAVLpane);
		Stage stageSearch = new Stage();
		stageSearch.setScene(sceneSearch);

		/* AVL HEIGHT STAGE */
		AnchorPane heightPane = new AnchorPane();
		heightPane.setPrefHeight(464.0);
		heightPane.setPrefWidth(699.0);
		Label Heightlbl = new Label();
		Heightlbl.setFont(new Font("Modern No. 20", 40));
		Button btnHide = new Button("HIDE");
		btnHide.setFont(new Font("Modern No. 20", 25));
		Button btnTHash = new Button("TO HASH");
		btnTHash.setFont(new Font("Modern No. 20", 25));
		heightPane.getChildren().addAll(Heightlbl, btnHide, btnTHash);
		Heightlbl.setLayoutX(103.0);
		Heightlbl.setLayoutY(179.0);
		Heightlbl.setPrefHeight(76.0);
		Heightlbl.setPrefWidth(520.0);
		btnHide.setLayoutX(26.0);
		btnHide.setLayoutY(374.0);
		btnTHash.setLayoutX(368.0);
		btnTHash.setLayoutY(374.0);
		btnTHash.setPrefHeight(57.0);
		btnHide.setPrefHeight(57.0);
		btnHide.setPrefWidth(323.0);
		btnTHash.setPrefWidth(323.0);
		Stage stageHeight = new Stage();
		Scene sceneHight = new Scene(heightPane);
		stageHeight.setScene(sceneHight);

		/* END AVL HEIGHT STAGE */
		txtTree.setFont(new Font("Modern No. 20", 30));

		AnchorPane tPane = new AnchorPane();

		VBox vAvl = new VBox();
		Button btnPrint = new Button("Print Cities Sorted");
		Button btnSearch = new Button("Search City ");
		Button btnInsert = new Button("Insert New City ");
		Button btnDelete = new Button("Delete City");
		Button btnHeight = new Button("Calcuate Tree Height");
		Button btnBack = new Button("Main Window");
		btnPrint.setPrefWidth(200);
		btnDelete.setPrefWidth(200);
		btnBack.setPrefWidth(200);
		btnInsert.setPrefWidth(200);
		btnSearch.setPrefWidth(200);
		btnHeight.setPrefWidth(200);
		tPane.setPrefHeight(700.0);
		tPane.setPrefWidth(800.0);
		HTree.getChildren().addAll(vAvl, txtTree);
		HTree.setPadding(new Insets(20, 0, 0, 0));
		vAvl.getChildren().addAll(btnPrint, btnSearch, btnInsert, btnDelete, btnHeight, btnBack);

		vAvl.setSpacing(60.0);

		tPane.getChildren().add(HTree);

		vAvl.setPadding(new Insets(0, 0, 0, 20));
		Scene tscene = new Scene(tPane, 800, 500);

		/* END AVL Tree MAIN MENU WINDOW */

		FileChooser fileChooser = new FileChooser();

		fileChooser.setTitle("Open Equaltions File");

		fileChooser.getExtensionFilters().addAll(new ExtensionFilter("Text Files", "*.txt"));

		/* MAIN MENU */

		AnchorPane MPane = new AnchorPane();

		Button btnGT = new Button(" AVL Tree");

		Button btnHashButton = new Button("Hash");
		Button btnGB = new Button(" Go Back");
		MPane.getChildren().addAll(btnGT, btnHashButton, btnGB);
		btnGB.setPrefHeight(60.0);
		btnGB.setPrefWidth(180.0);
		btnGT.setPrefHeight(60.0);
		btnGT.setPrefWidth(180.0);
		btnHashButton.setPrefHeight(60.0);
		btnHashButton.setPrefWidth(180.0);
		btnGB.setLayoutY(500.0);
		btnGB.setLayoutX(305.0);
		stageHeight.setTitle("Show AVL tree Height");
		btnGT.setLayoutX(305.0);
		btnGT.setLayoutY(280.0);

		btnHashButton.setLayoutY(400.0);
		btnHashButton.setLayoutX(305.0);
		Scene MainN = new Scene(MPane, 800, 600);
		MPane.prefHeight(478.0);
		MPane.prefWidth(610.0);

		/* END MAIN MENU */

		btnGB.setOnAction(e -> {
			primaryStage.setScene(scene);
			primaryStage.setTitle("project 3");

		});

		btnGT.setOnAction(e -> {
			primaryStage.setScene(tscene);
			primaryStage.setTitle("AVL Main Menu");
		});

		btnMain.setOnAction(e -> {
			cities.clearTree();
			String currentPath = Paths.get(".").toAbsolutePath().normalize().toString();
			fileChooser.setInitialDirectory(new File(currentPath));
			File selectedFile = fileChooser.showOpenDialog(primaryStage);
			if (selectedFile != null) {
				if (loadFile(cities, selectedFile, cboCity)) {
					primaryStage.setScene(MainN);
					primaryStage.setTitle("Main Menu");
				} else
					ShowMessage(Alert.AlertType.WARNING, "Warning", "THe file is empty or Not Main city File ");

			}

		});

		btnPrint.setOnAction(e -> {
			cities.Sortedlist = "";
			txtTree.setText("");
			cities.traverseInOrder();
			txtTree.setText(cities.Sortedlist);
		});
		/* Search Button */
		btnSearch.setOnAction(e -> {
			btnCSearch.setText("Search");
			stageSearch.setTitle("Search For A City ");
			stageSearch.show();
			txtTree.clear();
			txtFName.setVisible(false);
			lblFname.setVisible(false);
			btnCSearch.setOnAction(a -> {
				String name = txtCName.getText();
				if (isChar(name.trim())) {
					TNode Result = cities.find(new City(name.trim()));
					if (Result != null) {
						stageSearch.hide();
						txtTree.setText(Result.toString());
						ShowMessage(Alert.AlertType.INFORMATION, "Search Result", "The City is  Found ");
					} else {
						stageSearch.hide();
						ShowMessage(Alert.AlertType.INFORMATION, "Search Result", "The City Is Not Found ");
					}
					txtFName.setVisible(true);
					lblFname.setVisible(true);
				} else
					ShowMessage(Alert.AlertType.WARNING, "WARNING", "Enter THe name of the city to search ");

			});
			txtCName.clear();
			txtFName.clear();
			txtTree.clear();

		});
		/* end Search Button */

		/* Insert Button */
		btnInsert.setOnAction(e -> {
			txtFName.setVisible(true);
			lblFname.setVisible(true);

			btnCSearch.setText("Insert");
			stageSearch.setTitle("Add new City ");
			stageSearch.show();
			btnCSearch.setOnAction(a -> {
				if (isChar(txtCName.getText()) && isChar(txtFName.getText())) {
					String name = txtCName.getText();
					String fileName = txtFName.getText();

					Character ch = new Character(name.toUpperCase().charAt(0));
					ch.toUpperCase(ch);
					name = name.substring(1);
					name = ch + name;
					City c = new City(name, fileName);
					cities.insert(c);
					stageSearch.hide();
					ShowMessage(Alert.AlertType.INFORMATION, "Insert Result", "The City has Been Succssfully Added  ");
				} else
					ShowMessage(Alert.AlertType.WARNING, "WARNING", "Enter City Name And File Name ");
			});
			txtCName.clear();
			txtFName.clear();
			txtTree.clear();
		});
		/* end Insert Button */

		btnDelete.setOnAction(e -> {
			txtFName.setVisible(false);
			lblFname.setVisible(false);
			btnCSearch.setText("Delete");
			stageSearch.setTitle("Delete City");
			stageSearch.show();
			btnCSearch.setOnAction(a -> {
				String Name = txtCName.getText();
				if (isChar(Name)) {

					City c = new City(Name);
					TNode DeleteNode = cities.delete(c);
					if (DeleteNode != null) {
						stageSearch.hide();
						ShowMessage(Alert.AlertType.INFORMATION, "Delete Result", "The City has Been Deleted  ");
					} else {
						stageSearch.hide();
						ShowMessage(Alert.AlertType.INFORMATION, "Delete Result", "The City is Not Found   ");
					}
				} else {

					ShowMessage(Alert.AlertType.WARNING, "WARNing  ", "Enter City name And File Name  ");

				}

			});
			txtCName.clear();
			txtFName.clear();
			txtTree.clear();
		});

		btnBack.setOnAction(e -> {
			primaryStage.setScene(MainN);
			primaryStage.setTitle("Main Menu");
			txtTree.clear();
		});

		/* AVL TREE END */

		/* MAin HASH */
		AnchorPane paneMainHash = new AnchorPane();
		paneMainHash.setPrefHeight(400.0);
		paneMainHash.setPrefWidth(600);
		Label mainhashLabel = new Label(" Pick A City ");
		mainhashLabel.setFont(new Font("Modern No. 20", 26.0));

		cboCity.setPrefHeight(39.0);
		cboCity.setPrefWidth(211.0);
		Button btnMainHash = new Button("Hash IT");
		btnMainHash.setFont(new Font("Modern No. 20", 26.0));
		Button btnHashGoback = new Button("Go Back");
		btnHashGoback.setFont(new Font("Modern No. 20", 26.0));
		btnMainHash.setPrefHeight(56.0);
		btnMainHash.setPrefWidth(202.0);
		btnHashGoback.setPrefWidth(202.0);
		btnHashGoback.setPrefHeight(56.0);
		paneMainHash.getChildren().addAll(mainhashLabel, cboCity, btnHashGoback, btnMainHash);
		mainhashLabel.setLayoutX(199.0);
		mainhashLabel.setLayoutY(63.0);
		mainhashLabel.setPrefHeight(40);
		mainhashLabel.setPrefWidth(250.0);
		cboCity.setLayoutX(187.0);
		cboCity.setLayoutY(302.0);
		btnHashGoback.setLayoutX(18.0);
		btnHashGoback.setLayoutY(200.0);
		btnMainHash.setLayoutX(369.0);
		btnMainHash.setLayoutY(200.0);

		/* HASH */
		AnchorPane paneHash = new AnchorPane();
		VBox vHash = new VBox();
		TextArea taHash = new TextArea();
		taHash.setPrefHeight(500);
		taHash.setPrefWidth(720);
		HBox HHAshbox = new HBox();

		Button btnPrinthash = new Button("Print hashed table");
		Button btnSize = new Button("Print out table size ");
		Button btnHashFunction = new Button("Print out used hash function ");
		Button btnPut = new Button("Insert a new record to hash table");
		Button btnFind = new Button("Search for a specific record");
		Button btnRemove = new Button("Delete a specific record");
		Button btnSave = new Button("Save hash table back to file");
		Button btnBackMHash = new Button("Main Hash");
		btnPrinthash.setPrefWidth(200);
		btnPut.setPrefWidth(200);
		btnBackMHash.setPrefWidth(200);
		btnRemove.setPrefWidth(200);
		btnSave.setPrefWidth(200);
		btnHashFunction.setPrefWidth(200);
		btnSize.setPrefWidth(200);
		btnFind.setPrefWidth(200);
		paneHash.setPrefHeight(550.0);
		paneHash.setPrefWidth(950.0);
		vHash.getChildren().addAll(btnPrinthash, btnSize, btnHashFunction, btnPut, btnFind, btnRemove, btnSave,
				btnBackMHash);
		vHash.setSpacing(40.0);
		HHAshbox.getChildren().addAll(vHash, taHash);

		paneHash.getChildren().add(HHAshbox);

		vHash.setPadding(new Insets(50, 0, 0, 20));
		Scene hash = new Scene(paneHash);

		/* Insert Only */

		AnchorPane buttonsHashpane = new AnchorPane();
		buttonsHashpane.setPrefHeight(476.0);
		buttonsHashpane.setPrefWidth(664.0);
		HBox hHash = new HBox();
		hHash.setPrefHeight(100.0);
		hHash.setPrefWidth(200.0);
		hHash.setSpacing(40.0);
		VBox vhashLabel = new VBox();
		vhashLabel.setPrefHeight(280.0);
		vhashLabel.setPrefWidth(231.0);
		vhashLabel.setSpacing(40.0);
		Label IDlabel = new Label("Id:");
		IDlabel.setPrefSize(155.0, 31.0);
		IDlabel.setAlignment(Pos.CENTER_LEFT);
		IDlabel.setFont(new Font("Modern No. 20", 25.0));
		Label lblFNameHash = new Label("Full Name:");
		lblFNameHash.setAlignment(Pos.CENTER);
		lblFNameHash.setFont(new Font("Modern No. 20", 25.0));
		Label lblAge = new Label("Age:");
		lblAge.setAlignment(Pos.CENTER_RIGHT);
		lblAge.setFont(new Font("Modern No. 20", 25.0));
		Label lblGender = new Label("Gender:");
		lblGender.setAlignment(Pos.CENTER_RIGHT);
		lblGender.setFont(new Font("Modern No. 20", 25.0));
		vhashLabel.getChildren().addAll(IDlabel, lblFNameHash, lblAge, lblGender);
		VBox vhashField = new VBox();
		vhashField.setSpacing(50.0);
		vhashField.setPrefHeight(168.0);
		vhashField.setPrefWidth(177.0);
		hResident = new HashTable();
		TextField txtId = new TextField();
		TextField txtFnameHash = new TextField();
		TextField txtAGe = new TextField();
		ToggleGroup TgHAsh = new ToggleGroup();
		RadioButton rbMale = new RadioButton("Male");
		rbMale.setToggleGroup(TgHAsh);
		RadioButton rbFemale = new RadioButton("Female");
		HBox hRBox = new HBox();
		taHash.setFont(new Font(16));

		hRBox.setPrefHeight(400);
		hRBox.setPrefWidth(400);
		rbFemale.setToggleGroup(TgHAsh);
		rbMale.setFont(new Font("Modern No. 20", 18.0));
		rbFemale.setFont(new Font("Modern No. 20", 18.0));
		hRBox.setSpacing(10);
		hRBox.getChildren().addAll(rbMale, rbFemale);
		rbMale.setSelected(true);
		vhashField.getChildren().addAll(txtId, txtFnameHash, txtAGe, hRBox);
		hHash.getChildren().addAll(vhashLabel, vhashField);

		Button btnHashbuttons = new Button("Insert");
		btnHashbuttons.setFont(new Font("Modern No. 20", 24.0));
		btnHashbuttons.setLayoutX(212.0);
		btnHashbuttons.setLayoutY(392.0);
		buttonsHashpane.getChildren().addAll(hHash, btnHashbuttons);
		buttonsHashpane.setPadding(new Insets(100, 0, 0, 50));
		hHash.setLayoutX(49.0);
		hHash.setLayoutY(14.0);
		buttonsHashpane.setBottomAnchor(hHash, 102.0);
		buttonsHashpane.setLeftAnchor(hHash, 49.0);
		buttonsHashpane.setRightAnchor(hHash, 66.0);
		buttonsHashpane.setTopAnchor(hHash, 14.0);
		Scene sceneButtonsHash = new Scene(buttonsHashpane);
		Stage stageButtonsHash = new Stage();

		/* Insert ENd */

		/* delete search Start */
		AnchorPane dsHashpane = new AnchorPane();
		dsHashpane.setPrefHeight(100.0);
		dsHashpane.setPrefWidth(464.0);
		HBox hds = new HBox();
		hds.setPrefHeight(40.0);
		hds.setPrefWidth(50.0);
		hds.setSpacing(40.0);
		VBox vhashSechdel = new VBox();
		vhashSechdel.setPrefHeight(60.0);
		vhashSechdel.setPrefWidth(120.0);
		vhashSechdel.setSpacing(40.0);
		Label lblidserdel = new Label("Id:");
		lblidserdel.setPrefSize(115.0, 31.0);
		lblidserdel.setAlignment(Pos.CENTER_LEFT);
		lblidserdel.setFont(new Font("Modern No. 20", 20.0));
		vhashSechdel.getChildren().addAll(lblidserdel);
		VBox vds = new VBox();
		vds.setSpacing(20.0);
		vds.setPrefHeight(100.0);
		vds.setPrefWidth(200.0);
		hds.setPadding(new Insets(5, 0, 0, 0));
		TextField txtIddelser = new TextField();

		vds.getChildren().addAll(txtIddelser);
		hds.getChildren().addAll(vhashSechdel, vds);

		Button btnHashdelser = new Button("Search");
		btnHashdelser.setFont(new Font("Modern No. 20", 20.0));
		btnHashdelser.setLayoutX(212.0);
		btnHashdelser.setLayoutY(100.0);
		dsHashpane.getChildren().addAll(hds, btnHashdelser);
		dsHashpane.setPadding(new Insets(15, 0, 0, 15));
		hds.setLayoutX(49.0);
		hds.setLayoutY(200.0);
		dsHashpane.setBottomAnchor(hds, 102.0);
		dsHashpane.setLeftAnchor(hds, 49.0);
		dsHashpane.setRightAnchor(hds, 66.0);
		dsHashpane.setTopAnchor(hds, 14.0);
		Scene scenedsHash = new Scene(dsHashpane);
		Stage stagedssHash = new Stage();
		stagedssHash.setScene(scenedsHash);

		/* delete search End */

		/* Print hash Function and table size */

		AnchorPane aHashfunction = new AnchorPane();
		aHashfunction.setPrefWidth(699.0);
		aHashfunction.setPrefHeight(464.0);
		Label lblHashFunction = new Label();
		lblHashFunction.setFont(new Font("Modern No. 20", 25.0));
		Button btnsizefunction = new Button("Hide");
		btnsizefunction.setFont(new Font("Modern No. 20", 25.0));
		aHashfunction.getChildren().addAll(lblHashFunction, btnsizefunction);
		lblHashFunction.setLayoutX(39.0);
		lblHashFunction.setLayoutY(176);
		btnsizefunction.setLayoutX(26.0);
		btnsizefunction.setLayoutY(374.0);
		Scene Hashscene = new Scene(aHashfunction);
		Stage stagehashfunction = new Stage();
		stagehashfunction.setScene(Hashscene);

		/* End Print hash Function and table size */

		btnSize.setOnAction(e -> {
			stagehashfunction.setTitle("Show Table Size");
			stagehashfunction.show();
			lblHashFunction.setText("The Table Size is :   " + hResident.getTablesize() + " \n The Current Size is :  "
					+ hResident.getCurrentSize());
			btnsizefunction.setOnAction(a -> {
				stagehashfunction.hide();

			});
		});

		btnHashFunction.setOnAction(e -> {
			stagehashfunction.setTitle("Show Hash Function");
			stagehashfunction.show();
			char segma = '\u03a3';
			lblHashFunction.setText("Quadratic probing:\n" + " Hash Function :   (" + segma
					+ "id.charAt(i))*Math.pow(2,i) ) % " + "Table Size" + "\n for i = 0 -> lenght of the String ID ");
			btnsizefunction.setOnAction(a -> {
				stagehashfunction.hide();

			});
		});

		stageButtonsHash.setScene(sceneButtonsHash);
		stageButtonsHash.setTitle("Add A New Resident");
		btnPut.setOnAction(e -> {
			btnHashbuttons.setText("Insert");
			stageButtonsHash.show();

			btnHashbuttons.setOnAction(a -> {
				char gen;
				if (rbMale.isSelected()) {
					gen = 'M';
				} else {
					gen = 'F';
				}
				String ID = "";
				String FullName = "";
				int Age = 0;
				if (isValidNumber(txtId.getText())) {
					ID = txtId.getText();
					if (isChar(txtFnameHash.getText())) {
						FullName = txtFnameHash.getText();

						if (isValidNumber(txtAGe.getText())) {
							Age = Integer.parseInt(txtAGe.getText());

							Resident R = new Resident(ID, FullName, Age, gen);
							hResident.insert(R.getId(), R);
							stageButtonsHash.hide();
						}

						else
							ShowMessage(Alert.AlertType.WARNING, "WARNING", "Only Digit Input ");

					} else
						ShowMessage(Alert.AlertType.WARNING, "WARNING", "Write on the NAME field  only Character ");
				} else
					ShowMessage(Alert.AlertType.WARNING, "WARNING", "Write on the ID number only ");

			});
			rbMale.setSelected(true);
			txtId.clear();
			txtFnameHash.clear();
			txtAGe.clear();

		});

		Scene sceneHash = new Scene(paneMainHash);
		btnHashButton.setOnAction(e -> {
			primaryStage.setTitle("Pick A City");
			primaryStage.setScene(sceneHash);
		});

		btnMainHash.setOnAction(e -> {
			taHash.clear();
			hResident.makeEmpty();
			if (cboCity.getValue() != null) {
				String selected = cboCity.getValue().getCityFile().toString();
				if (selected != null) {
					System.out.println(selected);
					File read = new File(selected);
					if (read.exists()) {
						Scanner src;
						try {
							/* Read a city file */

							src = new Scanner(read);
							while (src.hasNext()) {
								String Token[] = src.nextLine().split("/");
								if (Token.length == 4) {

									Resident person = new Resident(Token[0].trim(), Token[1],
											Integer.parseInt(Token[2]), Token[3].charAt(0));
									hResident.insert(person.getId(), person);
								}

							}

							primaryStage.setScene(hash);
							primaryStage.setTitle("Main Hash Menu");

							src.close();
						} catch (FileNotFoundException e1) {

							e1.printStackTrace();
						}
					} else
						ShowMessage(Alert.AlertType.WARNING, "Warning ", "The current city doesn't has a file ");
				}
			} else
				ShowMessage(Alert.AlertType.WARNING, "Warning ", "please select a  city ");

		});
		btnHashGoback.setOnAction(e -> {
			primaryStage.setScene(MainN);
			primaryStage.setTitle("Main Menu");
		});
		btnBackMHash.setOnAction(e -> {
			primaryStage.setScene(sceneHash);
			primaryStage.setTitle("Pick A City");
			taHash.clear();
		});

		btnHeight.setOnAction(e -> {
			
			Heightlbl.setText("The Tree Height is  " + cities.height());
		System.out.println(cities.height());
			stageHeight.show();
			btnHide.setOnAction(a -> {
				stageHeight.hide();
			});

			btnTHash.setOnAction(h -> {
				stageHeight.hide();
				primaryStage.setScene(sceneHash);
				primaryStage.setTitle("Pick A City");
				txtTree.clear();
			});
		});
		btnPrinthash.setOnAction(e -> {
			taHash.clear();
			String result = hResident.printonfile();
			taHash.setText(result);
		});
		btnFind.setOnAction(e -> {
			taHash.clear();
			btnHashdelser.setText("Search");
			stagedssHash.setTitle("Search For A Resident");
			stagedssHash.show();

			btnHashdelser.setOnAction(a -> {
				String ID = txtIddelser.getText();
				if (isValidNumber(ID)) {
					stagedssHash.hide();
					String x = hResident.Find(ID);
					if (x != null)
						taHash.setText(x);
					else
						ShowMessage(Alert.AlertType.WARNING, "Warning ", "The currnet record is not found ");

				}

			});
			txtIddelser.clear();

		});
		btnSave.setOnAction(e -> {
			fileChooser.setTitle("Save Residents To File");
			String currentPath = Paths.get(".").toAbsolutePath().normalize().toString();
			fileChooser.setInitialDirectory(new File(currentPath));
			File selectedFile = fileChooser.showSaveDialog(primaryStage);
			if (selectedFile != null) {
				String txtString = hResident.printonfile();

				try {
					FileWriter fw = new FileWriter(selectedFile);
					fw.write(txtString);
					fw.close();
					ShowMessage(Alert.AlertType.INFORMATION, "File Saved",
							"All records are saved successfully to file  " + selectedFile);
				} catch (IOException e2) {

					e2.printStackTrace();
				}
			}

		});

		btnRemove.setOnAction(e -> {
			btnHashdelser.setText("Delete");
			stagedssHash.setTitle("Delete A Resident");
			stagedssHash.show();
			btnHashdelser.setOnAction(a -> {
				String ID = txtIddelser.getText();

				if (isValidNumber(ID)) {
					stagedssHash.hide();
					String x = hResident.delete(ID).toString();
					if (x != "Not Found")
						taHash.setText(x);
					else
						ShowMessage(Alert.AlertType.WARNING, "Warning ", "The currnet record is not found ");

				}
			});
			txtIddelser.clear();
		});

	}

	public void ShowMessage(AlertType alert, String Header, String ContentText) {
		Alert alt = new Alert(null);
		alt.setAlertType(alert);
		alt.setHeaderText(Header);
		alt.setContentText(ContentText);
		alt.showAndWait();

	}

	private boolean loadFile(AVLTree<City> cities, File selectedFile, ComboBox<City> coboCity) {
		coboCity.getItems().clear();
		Scanner src;
		try {
			src = new Scanner(selectedFile);
			if (src.hasNext()) {

				String line = "";
				while (src.hasNext()) {
					line = src.nextLine();
					String toke[] = line.split("/");
					if (toke.length == 2) {
						String filename= toke[1].trim();
						int index = filename.lastIndexOf('.');
						filename= filename.substring(0,index);
						filename+=".txt";
						City c = new City(toke[0].trim(), filename);
						coboCity.getItems().add(c);
						cities.insert(c);
					}

				}
				src.close();
				if (!line.contains(".txt"))
					return false;

				return true;
			}
			return false;
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		}

		return false;
	}

	private boolean isValidNumber(String num) { // method that will check if the text is Valid Number and return true or
												// false

		Pattern pattren = Pattern.compile("[0-9]+");
		Matcher matcher = pattren.matcher(num);
		if (matcher.find() && matcher.group().equals(num))
			return true;
		return false;

	}

	private boolean isChar(String ch) {

		Pattern pattren = Pattern.compile("[a-zA-Z[ ]].+");
		Matcher matcher = pattren.matcher(ch);
		if (matcher.find() && matcher.group().equals(ch))
			return true;
		return false;
	}

}
