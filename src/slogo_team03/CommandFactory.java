package slogo_team03;

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

public class CommandFactory {
	public CommandFactory() {}
	
	public Command createCommand(String name)  {
		name = name.toLowerCase();
		//Turtle Commands
		if (name.equals("forward") || name.equals("fd")) {
			return new Forward();
		}
		else if (name.equals("back") || name.equals("bk")) {
			return new Back();
		}
		else if (name.equals("left") || name.equals("lt")) {
			return new Left();
		}
		else if (name.equals("right") || name.equals("rt")) {
			return new Right();
		}
		else if (name.equals("setheading") || name.equals("seth")) {
			return new SetHeading();
		}
		else if (name.equals("towards")) {
			return new Towards();
		}
		else if (name.equals("setxy") || name.equals("goto")) {
			return new SetXY();
		}
		else if (name.equals("pendown") || name.equals("pd")) {
			return new PenDown();
		}
		else if (name.equals("penup") || name.equals("pu")) {
			return new PenUp();
		}
		else if (name.equals("showturtle") || name.equals("st")) {
			return new ShowTurtle();
		}
		else if (name.equals("hideturtle") || name.equals("ht")) {
			return new HideTurtle();
		}
		else if (name.equals("home")) {
			return new Home();
		}
		else if (name.equals("clearscreen") || name.equals("cs")) {
			return new ClearScreen();
		}
		//Turtle Queries
		else if (name.equals("xcor")) {
			return new XCor();
		}
		else if (name.equals("ycor")) {
			return new YCor();
		}
		else if (name.equals("heading")) {
			return new Heading();
		}
		else if (name.equals("pendown?") || name.equals("pendownp")) {
			return new PenDownP();
		}
		else if (name.equals("showing?") || name.equals("showingp")) {
			return new ShowingP();
		}
		//Math Operations
		else if (name.equals("sum") || name.equals("+")) {
			return new Sum();
		}
		else if (name.equals("difference") || name.equals("-")) {
			return new Difference();
		}
		else if (name.equals("product") || name.equals("*")) {
			return new Product();
		}
		else if (name.equals("quotient") || name.equals("/")) {
			return new Quotient();
		}
		else if (name.equals("remainder") || name.equals("%")) {
			return new Remainder();
		}
		else if (name.equals("minus") || name.equals("~")) {
			return new Minus();
		}
		else if (name.equals("random")) {
			return new RandomCommand();
		}
		else if (name.equals("sin")) {
			return new Sin();
		}
		else if (name.equals("cos")) {
			return new Cos();
		}
		else if (name.equals("tan")) {
			return new Tan();
		}
		else if (name.equals("atan")) {
			return new ATan();
		}
		else if (name.equals("log")) {
			return new Log();
		}
		else if (name.equals("pow")) {
			return new Pow();
		}
		else if (name.equals("pi")) {
			return new Pi();
		}
		//Boolean Operations
		else if (name.equals("less?") || name.equals("lessp")) {
			return new LessP();
		}
		else if (name.equals("greater?") || name.equals("greaterp")) {
			return new GreaterP();
		}
		else if (name.equals("equal?") || name.equals("equalp")) {
			return new EqualP();
		}
		else if (name.equals("notequal?") || name.equals("notequalp")) {
			return new NotEqualP();
		}
		else if (name.equals("and")) {
			return new And();
		}
		else if (name.equals("or")) {
			return new Or();
		}
		else if (name.equals("not")) {
			return new Not();
		}
		//Variables, Control Structures, and User-Defined Commands
		else if (name.equals("make") || name.equals("set")) {
			return new Make();
		}
		else if (name.equals("repeat")) {
			return new Repeat();
		}
		else if (name.equals("dotimes")) {
			return new DoTimes();
		}
		else if (name.equals("for")) {
			return new For();
		}
		else if (name.equals("if")) {
			return new If();
		}
		else if (name.equals("ifelse")) {
			return new IfElse();
		}
		else if (name.equals("to")) {
			return new To();
		}
		else {
			return null;
		}
	}
}