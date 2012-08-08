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

import java.util.ArrayList;
import java.util.List;

import org.exoplatform.webui.application.WebuiRequestContext;
import org.exoplatform.webui.config.annotation.ComponentConfig;
import org.exoplatform.webui.config.annotation.EventConfig;
import org.exoplatform.webui.core.UIComponent;
import org.exoplatform.webui.core.UIContainer;
import org.exoplatform.webui.core.lifecycle.UIContainerLifecycle;
import org.exoplatform.webui.core.lifecycle.UIFormLifecycle;
import org.exoplatform.webui.event.Event;
import org.exoplatform.webui.event.EventListener;
import org.exoplatform.webui.form.UIForm;

import exoplatform.BookStoreService;
import exoplatform.bookstore.portlet.UIBookManagementPortlet;
import exoplatform.bookstore.service.BookstoreServiceUtil;
import exoplatform.entity.Book;
import exoplatform.exception.BookNotFoundException;

/**
 * Created by The eXo Platform SAS
 * Author : BinhNV
 *          binhnv@exoplatform.com
 * Aug 6, 2012  
 */
@ComponentConfig(
    template = "app:/groovy/webui/UIBookList.gtmpl",
    events = {
      @EventConfig(listeners=UIBookList.EditActionListener.class),
      @EventConfig(listeners=UIBookList.DeleteActionListener.class)
    }
)
public class UIBookList extends UIComponent {

  private List<Book> books = new ArrayList<Book>();
  
  public UIBookList() {
    
  }
  
  public static class EditActionListener extends EventListener<UIBookList> {

    @Override
    public void execute(Event<UIBookList> event) throws Exception {
      WebuiRequestContext ctx = event.getRequestContext();
      String bookId = ctx.getRequestParameter(OBJECTID);
      UIBookList uiBookList = event.getSource();
      UIPopupAction popupAction = uiBookList.getAncestorOfType(UIBookManagementPortlet.class)
                                            .getChild(UIPopupAction.class);
      popupAction.activate(UIBookEdit.class, 600, 400);
      UIBookEdit uiBookEdit = popupAction.getChild(UIBookEdit.class);
      ctx.addUIComponentToUpdateByAjax(popupAction);
    }
    
  }
  
  public static class DeleteActionListener extends EventListener<UIBookList> {

    @Override
    public void execute(Event<UIBookList> event) throws Exception {
      WebuiRequestContext ctx = event.getRequestContext();
      String bookId = ctx.getRequestParameter(OBJECTID);
      try {
        BookStoreService service = BookstoreServiceUtil.getBookstoreService();
        service.deleteBook(bookId);
      } catch (BookNotFoundException e) {
        e.printStackTrace();
      }
      ctx.addUIComponentToUpdateByAjax(event.getSource());
    }
    
  }
  
  /**
   * @return the books
   */
  public List<Book> getBooks() {
    books = BookstoreServiceUtil.getAllBook(); 
    return books;
  }

  /**
   * @param books the books to set
   */
  public void setBooks(List<Book> books) {
    this.books = books;
  }
  
}
