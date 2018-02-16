using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace replaceSpaces
{
    class Program
    {
        static void Main(string[] args)
        {
            Console.WriteLine(replaceSpaces("hello potato!", "%20"));
            Console.WriteLine(replaceSpaces("hello potato! I am tomato!", "M3M3Supreme"));
            Console.WriteLine(replaceSpaces("hello potato! I am tomato! That's tornado!", "!!!!!"));
            Console.ReadLine();
        }

        static string replaceSpaces(string str, string replaceString)
        {
            int spaceCount = str.Count(c => c == ' ');
            int additionalSpaceCount = spaceCount * replaceString.Length - spaceCount;
            int newLength = str.Length + additionalSpaceCount;

            char[] oldString = str.Trim().ToCharArray();
            char[] newString = new char[newLength];

            int oldStringIndex = oldString.Length - 1;
            string result;

            for(int i = newString.Length - 1; i >= 0; i--)
            {
                if (oldString[oldStringIndex] == ' ')
                {
                    for (int j = replaceString.Length - 1; j >= 0; j--)
                    {
                        newString[i] = replaceString.ElementAt(j);
                        i--;
                    }
                    oldStringIndex--;
                    i++;
                }
                else
                {
                    newString[i] = oldString[oldStringIndex];
                    oldStringIndex--;
                }
            }

            result = new string(newString);
            return result;
        }
    }
}
