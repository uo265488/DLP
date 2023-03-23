package symboltable;

import java.util.*;
import ast.definition.Definition;
import ast.type.ErrorType;
import errorhandler.ErrorHandler;

public class SymbolTable {
	
	private int scope=0;
	private List<Map<String,Definition>> table;
	public SymbolTable()  {
		table = new ArrayList<>();
		this.table.add(new HashMap<>());
	}

	public void set() {
		this.table.add(new HashMap<>());
		this.scope = scope + 1;
	}
	
	public void reset() {

		table.remove(scope);
		this.scope--;
	}
	
	public boolean insert(Definition definition) {
		if(this.findInCurrentScope(definition.getName()) == null) {
			table.get(scope).put(definition.getName(), definition);
			definition.setScope(this.scope);
			return true;
		} else {
			ErrorHandler.getInstance().addError(
					new ErrorType(
							definition.getLine(),
							definition.getColumn(),
							"Already exists a variable named: " + definition.getName() + " in this scope. "));
		}
		return false;
	}
	
	public Definition find(String id) {
		Definition def;
		for (Map<String, Definition> map : table) {
			def = map.get(id);
			if(def != null) {
				return def;
			}
		}
		return null;
	}

	public Definition findInCurrentScope(String id) {
		return this.table.get(scope).get(id);
	}
}
