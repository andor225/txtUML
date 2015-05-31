package hu.elte.txtuml.export.papyrus.elementsarrangers.gmflayout;

import java.util.Arrays;
import java.util.List;

import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.papyrus.uml.diagram.activity.edit.parts.ControlFlowGuardEditPart;
import org.eclipse.papyrus.uml.diagram.activity.edit.parts.ObjectFlowGuardEditPart;

/**
 * Controls the arranging of an ActivityDiagram with GMF algorithm
 *
 * @author Andr�s Dobreff
 */
public class ActivityDiagramElementsGmfArranger extends AbstractDiagramElementsGmfArranger {
	
	/**
	 * The Constructor 
	 * @param diagramEditPart - The EditPart of the diagram which elements is to arranged.
	 */
	public ActivityDiagramElementsGmfArranger(DiagramEditPart diagramEditPart) {
		super(diagramEditPart);
	}

	/*
	 * (non-Javadoc)
	 * @see hu.elte.txtuml.export.papyrus.elementsarrangers.IDiagramElementsArranger#arrange()
	 */
	@Override
	public void arrange() {
		EditPart activityEditpart = (EditPart) diagep.getChildren().get(0);
		EditPart activityContentEditpart = (EditPart) activityEditpart.getChildren().get(5);
		super.arrangeChildren(activityContentEditpart);
		@SuppressWarnings("unchecked")
		List<EditPart> listEp =  activityContentEditpart.getChildren();
		super.hideConnectionLabelsForEditParts(listEp, Arrays.asList(ObjectFlowGuardEditPart.class, ControlFlowGuardEditPart.class));
	}	
}
