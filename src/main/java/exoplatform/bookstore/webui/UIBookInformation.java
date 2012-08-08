/*
 * Copyright (C) 2003-2012 eXo Platform SAS.
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>.
 */
package exoplatform.bookstore.webui;

import org.exoplatform.webui.form.UIFormInputSet;
import org.exoplatform.webui.form.UIFormStringInput;

/**
 * Created by The eXo Platform SAS
 * Author : BinhNV
 *          binhnv@exoplatform.com
 * Aug 8, 2012  
 */
public class UIBookInformation extends UIFormInputSet {

  public UIBookInformation(String name) {
    super("UIBookInformation");
    addUIFormInput(new UIFormStringInput("bookId", "bookId", "bookId"));
    addUIFormInput(new UIFormStringInput("name", "name", "name"));
    addUIFormInput(new UIFormStringInput("category", "category", "category"));
    addUIFormInput(new UIFormStringInput("content", "content", "content"));
  }
  
}
