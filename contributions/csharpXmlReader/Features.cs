using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Xml;

namespace csharpXmlReader
{
    public class Features
    {
        public static decimal Total()
        {
            decimal total = 0;
            // Create an XML reader for this file.
            using (var reader = XmlReader.Create("company.xml"))
            {
                while (reader.Read())
                {
                    if (!reader.IsStartElement("Salary")) continue;
                    
                    // Next read will contain text.
                    if (reader.Read())
                    {
                        var s = reader.ReadContentAsDecimal();
                        total += s;
                    } 
                }
            }

            return total;
        }
    
        public static void Cut()
        {
            var xml = "";
            using (var reader = XmlReader.Create("company.xml"))
            {
                while (reader.Read())
                {
                    if (!String.IsNullOrEmpty(reader.Name))
                    {
                        var el = @"<";
                        switch (reader.NodeType)
                        {
                            case XmlNodeType.EndElement:
                                el += @"/" + reader.Name;
                                break;
                            case XmlNodeType.Element:
                            case XmlNodeType.XmlDeclaration:
                                el += reader.Name;
                                break;
                        }

                        if (reader.AttributeCount > 0)
                        {
                            el += " ";
                            while (reader.MoveToNextAttribute())
                            {
                                var a = string.Format("{0}={1}", reader.Name, reader.Value);
                                el += a; 
                            }
                            xml += el + @">";
                        }
                        else
                        {
                            xml += el + reader.Value + @">"; 
                        }
                        if (reader.Name == "Salary")
                        {
                            if (reader.Read())
                            {
                                var s = reader.ReadContentAsDecimal() / 2;
                                xml += s + @"</Salary>";
                            } 
                        }
                    }
                    else
                    {
                        xml += reader.Value;
                    }
                }
            }

            using (var tw = new XmlTextWriter("company1.xml", Encoding.UTF8))
            {
                tw.WriteRaw(xml);
            }
        }
    }
}
