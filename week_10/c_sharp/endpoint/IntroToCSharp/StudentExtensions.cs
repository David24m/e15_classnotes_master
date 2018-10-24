using System;
namespace IntroToCSharp
{
	static class StudentExtensions
	{
		public static void Print(this Student student)
		{
			Console.WriteLine($"{student.Name}, {student.Age} years old");
		}
	}
}
