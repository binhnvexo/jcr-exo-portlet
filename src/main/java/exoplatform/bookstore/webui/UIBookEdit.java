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

import org.exoplatform.webui.config.annotation.ComponentConfig;
import org.exoplatform.webui.config.annotation.EventConfig;
import org.exoplatform.webui.core.UIContainer;
import org.exoplatform.webui.core.UIPopupComponent;
import org.exoplatform.webui.core.lifecycle.UIFormLifecycle;
import org.exoplatform.webui.event.Event;
import org.exoplatform.webui.event.EventListener;
import org.exoplatform.webui.form.UIForm;
import org.exoplatform.webui.form.UIFormInputSet;

import exoplatform.entity.Book;

/**
 * Created by The eXo Platform SAS
 * Author : BinhNV
 *          binhnv@exoplatform.com
 * Aug 8, 2012  
 */
@ComponentConfig(
   lifecycle = UIFormLifecycle.class,
   template = "system:/groovy/webui/form/UIForm.gtmpl",
   events = {
     @EventConfig(listeners = UIBookEdit.EditActionListener.class)
   }
)
public class UIBookEdit extends UIForm implements UIPopupComponent {

  private Book book;
  
  /**
   * 
   */
  public UIBookEdit() {
    UIFormInputSet uiBookInformation = new UIBookInformation("UIBookInformation");
    addChild(uiBookInformation);
    setActions(new String[] {"Edit"});
  }
  
  public static class EditActionListener extends EventListener<UIBookEdit> {

    @Override
    public void execute(Event<UIBookEdit> event) throws Exception {
      
    }
    
  }

  /**
   * @return the book
   */
  public Book getBook() {
    return book;
  }

  /**
   * @param book the book to set
   */
  public void setBook(Book book) {
    this.book = book;
  }

  @Override
  public void activate() throws Exception {
    // TODO Auto-generated method stub
    
  }

  @Override
  public void deActivate() throws Exception {
    // TODO Auto-generated method stub
    
  }

}
