using System;
using System.IO;
using System.Xml.Schema;

namespace XsdValidator
{
    internal class Program
    {
        private static void Main(string[] args)
        {
            Console.WriteLine("(C) 2011-2012 XSDValidator @ softlang in Koblenz");
            if (args.Length < 1)
            {
                Console.WriteLine("Usage: XSDValidator file.xsd");
                Environment.Exit(-1);
            }

            var fileName = args[0];
            if (!fileName.EndsWith(".xsd"))
            {
                Console.WriteLine(string.Format("-> {0} is not a valid XSD file", fileName));
                Environment.Exit(-1);
            }
            try
            {
                using ( var fs = new FileStream(fileName, FileMode.Open, FileAccess.Read, FileShare.Read, 4096,
                                            FileOptions.SequentialScan))
                {
                    try
                    {
                        var errors = false;
                        XmlSchema.Read(fs, (x,y) => {
							errors = true;
							Console.WriteLine(y.Message);
						});
                        if(errors == true)
                            throw new Exception("Not a valid XSD");
                    }
                    catch(Exception ex)
                    {
						Console.WriteLine(ex.Message);
                        Console.WriteLine(string.Format("-> {0} is not a valid XSD file", fileName));
                        Environment.Exit(-1);
                    }
                }
            }
            catch (DirectoryNotFoundException ex)
            {
                Console.WriteLine(ex.Message);
                Environment.Exit(-1);
            }
            catch (FileNotFoundException ex)
            {
                Console.WriteLine(ex.Message);
                Environment.Exit(-1);
            }

            Console.WriteLine("-> Validation succeeded");
            Environment.Exit(0);
        }
    }
}