namespace xsdClasses
{
    using System;
    using System.Collections.Generic;
    using System.Linq;
    using System.Text;
    using System.IO;
    using System.Xml.Serialization;

    public static class Serialization
    {
        public static T Deserialize<T>(string fileName) where T: class, new()
        {
             using (var fs = new FileStream(fileName, FileMode.Open))
                {
                    var xs = new XmlSerializer(typeof(T));
                    var obj = xs.Deserialize(fs) as T;
                    return obj;
                }
        }

        public static void Serialize(string fileName, object obj)
        {
            using (var fs = new FileStream(fileName, FileMode.Create))
            {
                var xs = new XmlSerializer(obj.GetType());
                xs.Serialize(fs, obj);
            }
        }
    }
}
