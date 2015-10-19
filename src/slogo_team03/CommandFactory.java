package slogo_team03;

import java.util.ResourceBundle;

import commands.ATan;
import commands.And;
import commands.Back;
import commands.ClearScreen;
import commands.Command;
import commands.Cos;
import commands.Difference;
import commands.DoTimes;
import commands.EqualP;
import commands.For;
import commands.Forward;
import commands.GreaterP;
import commands.Heading;
import commands.HideTurtle;
import commands.Home;
import commands.If;
import commands.IfElse;
import commands.Left;
import commands.LessP;
import commands.Log;
import commands.Make;
import commands.Minus;
import commands.Not;
import commands.NotEqualP;
import commands.Or;
import commands.PenDown;
import commands.PenDownP;
import commands.PenUp;
import commands.Pi;
import commands.Pow;
import commands.Product;
import commands.Quotient;
import commands.RandomCommand;
import commands.Remainder;
import commands.Repeat;
import commands.Reset;
import commands.Right;
import commands.SetHeading;
import commands.SetXY;
import commands.ShowTurtle;
import commands.ShowingP;
import commands.Sin;
import commands.Sum;
import commands.Tan;
import commands.To;
import commands.Towards;
import commands.XCor;
import commands.YCor;
import newCommands.Ask;
import newCommands.AskWith;
import newCommands.ClearStamps;
import newCommands.ID;
import newCommands.PenColor;
import newCommands.SetBackground;
import newCommands.SetPalette;
import newCommands.SetPenColor;
import newCommands.SetPenSize;
import newCommands.SetShape;
import newCommands.Shape;
import newCommands.StampCommand;
import newCommands.Tell;
import newCommands.Turtles;

public class CommandFactory {
	private ResourceBundle language;
	private UserDefinedCommands userDefinedCommands;

	public CommandFactory(UserDefinedCommands userDefinedCommands) {
		language = ResourceBundle.getBundle("resources.languages/English");
		this.userDefinedCommands = userDefinedCommands;
	}

	public void receiveLanguage(String language) {
		this.language = ResourceBundle.getBundle("resources.languages/" + language);
	}

	public Command createCommand(String name) {
		name = name.toLowerCase();
		// Turtle Commands
		if (name.matches(language.getString("Forward"))) {
			return new Forward();
		} else if (name.matches(language.getString("Backward"))) {
			return new Back();
		} else if (name.matches(language.getString("Left"))) {
			return new Left();
		} else if (name.matches(language.getString("Right"))) {
			return new Right();
		} else if (name.matches(language.getString("SetHeading"))) {
			return new SetHeading();
		} else if (name.matches(language.getString("SetTowards"))) {
			return new Towards();
		} else if (name.matches(language.getString("SetPosition"))) {
			return new SetXY();
		} else if (name.matches(language.getString("PenDown"))) {
			return new PenDown();
		} else if (name.matches(language.getString("PenUp"))) {
			return new PenUp();
		} else if (name.matches(language.getString("ShowTurtle"))) {
			return new ShowTurtle();
		} else if (name.matches(language.getString("HideTurtle"))) {
			return new HideTurtle();
		} else if (name.matches(language.getString("Home"))) {
			return new Home();
		} else if (name.matches(language.getString("ClearScreen"))) {
			return new ClearScreen();
		}
		// Turtle Queries
		else if (name.matches(language.getString("XCoordinate"))) {
			return new XCor();
		} else if (name.matches(language.getString("YCoordinate"))) {
			return new YCor();
		} else if (name.matches(language.getString("Heading"))) {
			return new Heading();
		} else if (name.matches(language.getString("IsPenDown"))) {
			return new PenDownP();
		} else if (name.matches(language.getString("IsShowing"))) {
			return new ShowingP();
		}
		// Math Operations
		else if (name.matches(language.getString("Sum"))) {
			return new Sum();
		} else if (name.matches(language.getString("Difference"))) {
			return new Difference();
		} else if (name.matches(language.getString("Product"))) {
			return new Product();
		} else if (name.matches(language.getString("Quotient"))) {
			return new Quotient();
		} else if (name.matches(language.getString("Remainder"))) {
			return new Remainder();
		} else if (name.matches(language.getString("Minus"))) {
			return new Minus();
		} else if (name.matches(language.getString("Random"))) {
			return new RandomCommand();
		} else if (name.matches(language.getString("Sine"))) {
			return new Sin();
		} else if (name.matches(language.getString("Cosine"))) {
			return new Cos();
		} else if (name.matches(language.getString("Tangent"))) {
			return new Tan();
		} else if (name.matches(language.getString("ArcTangent"))) {
			return new ATan();
		} else if (name.matches(language.getString("NaturalLog"))) {
			return new Log();
		} else if (name.matches(language.getString("Power"))) {
			return new Pow();
		} else if (name.matches(language.getString("Pi"))) {
			return new Pi();
		}
		// Boolean Operations
		else if (name.matches(language.getString("LessThan"))) {
			return new LessP();
		} else if (name.matches(language.getString("GreaterThan"))) {
			return new GreaterP();
		} else if (name.matches(language.getString("Equal"))) {
			return new EqualP();
		} else if (name.matches(language.getString("NotEqual"))) {
			return new NotEqualP();
		} else if (name.matches(language.getString("And"))) {
			return new And();
		} else if (name.matches(language.getString("Or"))) {
			return new Or();
		} else if (name.matches(language.getString("Not"))) {
			return new Not();
		}
		// Variables, Control Structures, and User-Defined Commands
		else if (name.matches(language.getString("MakeVariable"))) {
			return new Make();
		} else if (name.matches(language.getString("Repeat"))) {
			return new Repeat();
		} else if (name.matches(language.getString("DoTimes"))) {
			return new DoTimes();
		} else if (name.matches(language.getString("For"))) {
			return new For();
		} else if (name.matches(language.getString("If"))) {
			return new If();
		} else if (name.matches(language.getString("IfElse"))) {
			return new IfElse();
		} else if (name.matches(language.getString("MakeUserInstruction"))) {
			return new To();
			// Display Commands
		} else if (name.matches(language.getString("SetBackground"))) {
			return new SetBackground();
		} else if (name.matches(language.getString("SetPenColor"))) {
			return new SetPenColor();
		} else if (name.matches(language.getString("SetPenSize"))) {
			return new SetPenSize();
		} else if (name.matches(language.getString("SetShape"))) {
			return new SetShape();
		} else if (name.matches(language.getString("SetPalette"))) {
			return new SetPalette();
		} else if (name.matches(language.getString("GetPenColor"))) {
			return new PenColor();
		} else if (name.matches(language.getString("GetShape"))) {
			return new Shape();
		} else if (name.matches(language.getString("Stamp"))) {
			return new StampCommand();
		} else if (name.matches(language.getString("ClearStamps"))) {
			return new ClearStamps();
		}
		// Multiple Turtle Commands
		else if (name.matches(language.getString("ID"))) {
			return new ID();
		} else if (name.matches(language.getString("Turtles"))) {
			return new Turtles();
		} else if (name.matches(language.getString("Tell"))) {
			return new Tell();
		} else if (name.matches(language.getString("Ask"))) {
			return new Ask();
		} else if (name.matches(language.getString("AskWith"))) {
			return new AskWith();
		}
		// User Defined Commands
		else if (userDefinedCommands.containsKey(name)) {
			return userDefinedCommands.getUserCommand(name);
		}
		// Custom Commands
		else if (name.matches(language.getString("Reset"))) {
			return new Reset();
		} else {
			return null;
		}
	}
}