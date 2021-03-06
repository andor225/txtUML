package hu.elte.txtuml.validation.problems.general;

import java.text.MessageFormat;

import org.eclipse.jdt.core.dom.ASTNode;

import hu.elte.txtuml.validation.Messages;
import hu.elte.txtuml.validation.SourceInfo;
import hu.elte.txtuml.validation.problems.ValidationErrorBase;
import hu.elte.txtuml.validation.problems.ValidationErrorCatalog;

public class InvalidChildrenElement extends ValidationErrorBase {

	private String nodeStr;
	private ASTNode child;

	public InvalidChildrenElement(SourceInfo sourceInfo, String nodeStr, ASTNode child) {
		super(sourceInfo, child);
		this.nodeStr = nodeStr;
		this.child = child;
	}

	@Override
	public int getID() {
		return ValidationErrorCatalog.INVALID_CHILDREN_ELEMENT.ordinal();
	}

	@Override
	public String getMessage() {
		return MessageFormat.format(Messages.InvalidChildrenElement_message, nodeStr, child.getClass().getSimpleName());
	}

}
