using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Text;
using System.Xml;
using System.Xml.Serialization;

namespace csharpBaseline
{
    public static class SerializationHelper
    {
        /// <summary>
        /// Method to reconstruct an Object from XML string
        /// </summary>
        /// <param name="xmlizedString"></param>
        /// <returns></returns>
        public static T DeserializeObject<T>(String xmlizedString) where T : class
        {
            var xs = new XmlSerializer(typeof(T));
            var memoryStream = new MemoryStream(StringToUtf8ByteArray(xmlizedString));

            return xs.Deserialize(memoryStream) as T;
        }

        /// <summary>
        /// Method to convert a custom Object to XML string
        /// </summary>
        /// <param name="object">Object that is to be serialized to XML</param>
        /// <param name="type"></param>
        /// <returns>XML string</returns>
        public static string SerializeObject(object @object, Type type)
        {
            String xmlizedString = null;
            try
            {
                var memoryStream = new MemoryStream();
                var xs = new XmlSerializer(type);
                var xmlTextWriter = new XmlTextWriter(memoryStream, Encoding.UTF8) { Formatting = Formatting.Indented };

                xs.Serialize(xmlTextWriter, @object);
                memoryStream = (MemoryStream)xmlTextWriter.BaseStream;
                xmlizedString = Utf8ByteArrayToString(memoryStream.ToArray());
            }

            catch (Exception e)
            {
                Console.WriteLine(e);
                return null;
            }

            return xmlizedString;
        }

        /// <summary>
        /// To convert a Byte Array of Unicode values (UTF-8 encoded) to a complete String.
        /// </summary>
        /// <param name="characters">Unicode Byte Array to be converted to String</param>
        /// <returns>String converted from Unicode Byte Array</returns>
        private static string Utf8ByteArrayToString(Byte[] characters)
        {
            var encoding = new UTF8Encoding();
            var constructedString = encoding.GetString(characters);
            return (constructedString);
        }

        /// <summary>
        /// Converts the String to UTF8 Byte array and is used in De serialization
        /// </summary>
        /// <param name="xmlString"></param>
        /// <returns></returns>
        private static Byte[] StringToUtf8ByteArray(string xmlString)
        {
            var encoding = new UTF8Encoding();
            var byteArray = encoding.GetBytes(xmlString);
            return byteArray;
        }
    }
}
