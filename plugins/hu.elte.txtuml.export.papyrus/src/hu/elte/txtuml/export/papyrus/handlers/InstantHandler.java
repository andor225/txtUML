package hu.elte.txtuml.export.papyrus.handlers;

import hu.elte.txtuml.export.papyrus.PapyrusVisualizer;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.ISelectionService;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eclipse.ui.progress.IProgressService;

/**
 * Handles the the call to visualization from context menu.
 *
 * @author Andr�s Dobreff
 */
public class InstantHandler extends AbstractHandler {
	
	/**
	 * Collects the parameters and calls the {@link PapyrusVisualizer#run()}
	 */
	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {

		IWorkbenchWindow window = HandlerUtil.getActiveWorkbenchWindowChecked(event);
		ISelectionService service = window.getSelectionService();
		IStructuredSelection structured = (IStructuredSelection) service.getSelection();
		
		IFile file = (IFile) structured.getFirstElement();
		IProject project = file.getProject();
		
		IProgressService progressService = PlatformUI.getWorkbench().getProgressService();
		
		PapyrusVisualizer pv = new PapyrusVisualizer(project.getName(), getFileNameWithOutExtension(file), file.getRawLocationURI().toString());
		
		try {
			progressService.runInUI(
					progressService,
				      new IRunnableWithProgress() {
				         public void run(IProgressMonitor monitor) {
				            pv.run(monitor);
				         }
				      },
				      ResourcesPlugin.getWorkspace().getRoot());
		} catch (InvocationTargetException | InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	
	/**
	 * Gets the FileName without extension
	 * @param file - The File
	 * @return - Filname without extension
	 */
	private String getFileNameWithOutExtension(IFile file){
		String name = file.getName();
		int pos = name.lastIndexOf(".");
		if (pos > 0) {
		    name = name.substring(0, pos);
		}
		return name;
	}

}