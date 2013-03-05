package jfragmentlocator;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Martin
 */
public class Query {
    public class QueryPart {
        private String classifier;
        private String name;
        
        public QueryPart(String classifier, String name) {
            this.classifier = classifier;
            this.name = name;
        }

        public String getClassifier() {
            return classifier;
        }

        public String getName() {
            return name;
        }
    }
    
    private int index = 0;
    private int ptr = -1;
    private List<QueryPart> parts = new ArrayList<QueryPart>();
    
    public Query(String query) {
        String tmp[] = query.split("/");
        int lengthModifier = 0;
        if (tmp.length % 2 == 1) {
            index = Integer.parseInt(tmp[tmp.length-1]);
            lengthModifier = -1;
        }
        
        for (int i = 0; i < (tmp.length + lengthModifier); i+=2)
            parts.add(new QueryPart(tmp[i], tmp[i+1]));
    }
    
    public List<Fragment> walk(Fact fact) {
        if (!hasNextPart())
            return fact.fragments;
        
        QueryPart part = nextPart();
        List<Fragment> result = new ArrayList<Fragment>();
        
        for (Fragment fragment : fact.fragments) {
            if (fragment.equals(part))
                result.add(fragment);
        }
        
        List<Fragment> tmp = walk(result);
        if (this.index > 0) {
            List<Fragment> r =  new ArrayList<Fragment>();
            r.add(tmp.get(index-1));
            return r;
        }
        return tmp;
    }
    
    private List<Fragment> walk(List<Fragment> fragments) {
        if (!hasNextPart())
            return fragments;
        
        QueryPart part = nextPart();
        List<Fragment> result = new ArrayList<Fragment>();
        
        for (Fragment fragment : fragments) {
            for (Fragment f : fragment.getFragments())
                if (f.equals(part))
                    result.add(f);
        }
        
        return walk(result);
    }
    
    private boolean hasNextPart() {
        return ptr+1 < parts.size();
    }
    
    private QueryPart nextPart() {
        ptr++;
        return parts.get(ptr);
    }
}
