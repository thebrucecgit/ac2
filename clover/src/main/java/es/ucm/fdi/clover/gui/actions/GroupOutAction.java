/*
 * AC - A source-code copy detector
 *
 *     For more information please visit: http://github.com/manuel-freire/ac2
 *
 * ****************************************************************************
 *
 * This file is part of AC, version 2.x
 *
 * AC is free software: you can redistribute it and/or modify it under the
 * terms of the GNU Lesser General Public License as published by the
 * Free Software Foundation, either version 3 of the License,
 * or (at your option) any later version.
 *
 * AC is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with AC.  If not, see <http://www.gnu.org/licenses/>.
 */
package es.ucm.fdi.clover.gui.actions;

import es.ucm.fdi.clover.gui.BaseInterface;

/**
 * Decrease cluster size == increase cluster number
 *
 * @author  mfreire
 */
public class GroupOutAction extends BaseAction {

	public GroupOutAction(BaseInterface app) {
		super(app, "group out", "img/expand.png", "Expand more nodes");
	}

	public void actionPerformed(java.awt.event.ActionEvent e) {

		getView(e).setMaxClusters((int) (getView(e).getMaxClusters() * 1.2));
		getView(e).recalculateDoI();
	}
}
