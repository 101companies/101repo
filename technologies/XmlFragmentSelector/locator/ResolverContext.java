/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package locator;

import com.sun.org.apache.xml.internal.utils.PrefixResolver;
import com.sun.org.apache.xml.internal.utils.PrefixResolverDefault;
import java.util.Iterator;
import javax.xml.namespace.NamespaceContext;
import org.w3c.dom.Node;

/**
 *
 * @author Martin
 */
public class ResolverContext implements NamespaceContext{
    private PrefixResolver resolver;
    
    public ResolverContext(Node xPathExpressionContext) {
        resolver = new PrefixResolverDefault(xPathExpressionContext);
    }
    
    @Override
    public String getNamespaceURI(String prefix) {
        return resolver.getNamespaceForPrefix(prefix);
    }

    //not supported
    @Override
    public String getPrefix(String namespaceURI) {
        return null;
    }

     //not supported
    @Override
    public Iterator getPrefixes(String namespaceURI) {
        return null;
    }
    
}
