package slogo_team03;
import java.util.List;

import commands.ATan;
import commands.And;
import commands.Back;
import commands.ClearScreen;
import commands.Command;
import commands.Cos;
import commands.Difference;
import commands.EqualP;
import commands.Forward;
import commands.GreaterP;
import commands.Heading;
import commands.HideTurtle;
import commands.Home;
import commands.Left;
import commands.LessP;
import commands.Log;
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
import commands.Right;
import commands.SetHeading;
import commands.SetXY;
import commands.ShowTurtle;
import commands.ShowingP;
import commands.Sin;
import commands.Sum;
import commands.Tan;
import commands.Towards;
import commands.XCor;
import commands.YCor;

public class CommandFactory {
	public CommandFactory() {}
	
	public Command createCommand(String name, List<String> inputList) {
		name = name.toLowerCase();
		//Turtle Commands
		if (name.equals("forward") || name.equals("fd")) {
			return new Forward(inputList);
		}
		else if (name.equals("back") || name.equals("bk")) {
			return new Back(inputList);
		}
		else if (name.equals("left") || name.equals("lt")) {
			return new Left(inputList);
		}
		else if (name.equals("right") || name.equals("rt")) {
			return new Right(inputList);
		}
		else if (name.equals("setheading") || name.equals("seth")) {
			return new SetHeading(inputList);
		}
		else if (name.equals("towards")) {
			return new Towards(inputList);
		}
		else if (name.equals("setxy") || name.equals("goto")) {
			return new SetXY(inputList);
		}
		else if (name.equals("pendown") || name.equals("pd")) {
			return new PenDown(inputList);
		}
		else if (name.equals("penup") || name.equals("pu")) {
			return new PenUp(inputList);
		}
		else if (name.equals("showturtle") || name.equals("st")) {
			return new ShowTurtle(inputList);
		}
		else if (name.equals("hideturtle") || name.equals("ht")) {
			return new HideTurtle(inputList);
		}
		else if (name.equals("home")) {
			return new Home(inputList);
		}
		else if (name.equals("clearscreen") || name.equals("cs")) {
			return new ClearScreen(inputList);
		}
		//Turtle Queries
		else if (name.equals("xcor")) {
			return new XCor(inputList);
		}
		else if (name.equals("ycor")) {
			return new YCor(inputList);
		}
		else if (name.equals("heading")) {
			return new Heading(inputList);
		}
		else if (name.equals("pendown?") || name.equals("pendownp")) {
			return new PenDownP(inputList);
		}
		else if (name.equals("showing?") || name.equals("showingp")) {
			return new ShowingP(inputList);
		}
		//Math Operations
		else if (name.equals("sum") || name.equals("+")) {
			return new Sum(inputList);
		}
		else if (name.equals("difference") || name.equals("-")) {
			return new Difference(inputList);
		}
		else if (name.equals("product") || name.equals("*")) {
			return new Product(inputList);
		}
		else if (name.equals("quotient") || name.equals("/")) {
			return new Quotient(inputList);
		}
		else if (name.equals("remainder") || name.equals("%")) {
			return new Remainder(inputList);
		}
		else if (name.equals("minus") || name.equals("~")) {
			return new Minus(inputList);
		}
		else if (name.equals("random")) {
			return new RandomCommand(inputList);
		}
		else if (name.equals("sin")) {
			return new Sin(inputList);
		}
		else if (name.equals("cos")) {
			return new Cos(inputList);
		}
		else if (name.equals("tan")) {
			return new Tan(inputList);
		}
		else if (name.equals("atan")) {
			return new ATan(inputList);
		}
		else if (name.equals("log")) {
			return new Log(inputList);
		}
		else if (name.equals("pow")) {
			return new Pow(inputList);
		}
		else if (name.equals("pi")) {
			return new Pi(inputList);
		}
		//Boolean Operations
		else if (name.equals("less?") || name.equals("lessp")) {
			return new LessP(inputList);
		}
		else if (name.equals("greater?") || name.equals("greaterp")) {
			return new GreaterP(inputList);
		}
		else if (name.equals("equal?") || name.equals("equalp")) {
			return new EqualP(inputList);
		}
		else if (name.equals("notequal?") || name.equals("notequalp")) {
			return new NotEqualP(inputList);
		}
		else if (name.equals("and")) {
			return new And(inputList);
		}
		else if (name.equals("or")) {
			return new Or(inputList);
		}
		else if (name.equals("not")) {
			return new Not(inputList);
		}
		//Variables, Control Structures, and User-Defined Commands
		else {
			return null;
		}
	}
}
