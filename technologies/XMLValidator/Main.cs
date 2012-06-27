using System;
using System.Collections.Generic;
using System.IO;
using System.Text;
using System.Xml;
using System.Xml.Schema;

namespace XMLValidator
{
    class Program
    {
        private static void Main(string[] args)
        {
            Console.WriteLine("(C) 2011 acceptXml @ softlang in Koblenz");
            if (args.Length < 1)
            {
                Console.WriteLine("Usage: acceptXml file.xml");
                Environment.Exit(-1);
            }

            var fileName = args[0];
            if (!fileName.EndsWith(".xml"))
            {
                Console.WriteLine(string.Format("-> {0} is not a valid XML file", fileName));
                Environment.Exit(-1);
            }
            try
            {
                using (var fs = new FileStream(fileName, FileMode.Open, FileAccess.Read, FileShare.Read, 4096,
                                            FileOptions.SequentialScan))
                {
                    try
                    {
                        XmlDocument doc = new XmlDocument();
                        doc.Load(fs);
                    }
                    catch
                    {
                        Console.WriteLine(string.Format("-> {0} is not a valid XML file", fileName));
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
