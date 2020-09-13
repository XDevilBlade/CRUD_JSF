/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.List;
import persistence.ViewUnitStatus;

/**
 *
 * @author Remy
 */
@javax.ejb.Local
public interface ManageViewUnitStatusInterface {
    public List<ViewUnitStatus> getAllViewUnitStatus();
    public ViewUnitStatus removeViewUnitStatus(ViewUnitStatus viewUnitStatus);
    public ViewUnitStatus createViewUnitStatus(ViewUnitStatus newViewUnitStatus);
    public ViewUnitStatus updateViewUnitStatus(ViewUnitStatus newViewUnitStatus);
}
