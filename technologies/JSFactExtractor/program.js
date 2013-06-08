#!/usr/bin/nodejs
var esprima = require('esprima');

process.stdin.resume();
var fs = require('fs');
var response = fs.readFileSync('/dev/stdin').toString();
process.stdin.pause();

var map = function(func, ls) {
    var r = [];
    for(var i=0; i<ls.length; i++) {
        r.push(func(ls[i]));
    }
    return r;
}

var filter = function(func, ls) {
    var r = [];
    for(var i=0; i<ls.length; i++) {
        if(func(ls[i])) {
            r.push(ls[i]);
        }
    }
    return r;
}

var clean = function(l) {
    l = filter(function(i) { if(i) { if(Array.isArray(i) && i.length == 0) { return false; } else { return true; } } }, l);
    // flatten list
    var r = [];
    for(var i=0; i<l.length; i++) {
        if(Array.isArray(l[i])) {
            for(var _i=0; _i<l[i].length; _i++) {
                r.push(l[i][_i]);
            }
        }   
        else {
            r.push(l[i]);
        }
    }
    return r;
}

var convert_to_facts = function(tree) {
    if(tree == null) {
        return [];
    }
    else if(tree.type == 'Program') {
        return clean(map(convert_to_facts, tree.body));
    }
    else if(tree.type == 'VariableDeclaration') {
        return convert_to_facts(tree.declarations[0]);
    }
    else if(tree.type == 'IfStatement') {
        var left = clean(convert_to_facts(tree.consequent));
        var right = clean(convert_to_facts(tree.alternate));
        right.concat(left);
        return right;
    }
    else if(tree.type == 'WhileStatement') {
        return clean(map(convert_to_facts, tree.body.body));
    }
    else if(tree.type == 'ForInStatement')  {
        return clean(map(convert_to_facts, tree.body.body));
    }
    else if(tree.type == 'ForStatement') {
        return clean(map(convert_to_facts, tree.body.body));
    }
    else if(tree.type == 'ReturnStatement') {
        return null;
    }
    else if(tree.type == 'FunctionDeclaration') {
        return {
            classifier: 'function',
            name: tree.id.name,
            
            fragments: clean(map(convert_to_facts, tree.body.body))
        };
    }
    else if(tree.type == 'ExpressionStatement') {
        if(tree.expression.type == 'MemberExpression') {
            //TODO: handle this
        }
        else {
            return null;
        }
    }
    else if(tree.type == 'VariableDeclarator') {
        if(tree.init.type == 'FunctionExpression') {
            return {
                classifier: 'function',
                name: tree.id.name,
                
                fragments: clean(map(convert_to_facts, tree.init.body.body))
                
            };
        }
        else {
            return {
                classifier: 'var',
                name: tree.id.name,
                
                fragments: []
                
            };
        }
    }
    else {
        return tree;
    }

}

console.log(JSON.stringify(convert_to_facts(esprima.parse(response)), null, 4));

