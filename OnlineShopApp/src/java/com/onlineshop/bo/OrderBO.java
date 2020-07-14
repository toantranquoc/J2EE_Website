/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.onlineshop.bo;

import com.onlineshop.dbconnection.DBConnectionService;
import com.onlineshop.dto.OrderDTO;
import com.onlineshop.mapper.OrderMapper;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.NamingException;
import javax.servlet.ServletContext;

/**
 *
 * @author pc
 */
public class OrderBO {

    private ServletContext context;

    public OrderBO(ServletContext context) {
        this.context = context;
    }

    public boolean AddNewOrder(OrderDTO order) {
        boolean result = false;
        OrderMapper mapper = null;
        try {
            mapper = new OrderMapper();
            result = mapper.AddNewOrder(order);
        } catch (Exception ex) {
            Logger.getLogger(UserBO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                mapper.closeConnection();
            } catch (Exception ex) {
                Logger.getLogger(UserBO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return result;
    }

    public int GetLastInsertID() {
        int result = -1;
        OrderMapper mapper = null;
        try {
            mapper = new OrderMapper();
            result = mapper.GetLastInsertOrderID();
        } catch (Exception ex) {
            Logger.getLogger(UserBO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                mapper.closeConnection();
            } catch (Exception ex) {
                Logger.getLogger(UserBO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return result;
    }

    public List<OrderDTO> GetListOrderByUserID(int UserID) {
        List<OrderDTO> list = new ArrayList<>();
        OrderMapper mapper = null;
        try {
            mapper = new OrderMapper();
            list = mapper.GetListOrderByUserID(UserID);
        } catch (Exception ex) {
            Logger.getLogger(UserBO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                mapper.closeConnection();
            } catch (Exception ex) {
                Logger.getLogger(UserBO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return list;
    }

    public int GetAllOrder() {
        int result = -1;
        OrderMapper mapper = null;
        try {
            mapper = new OrderMapper();
            result = mapper.GetLastInsertOrderID();
        } catch (Exception ex) {
            Logger.getLogger(UserBO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                mapper.closeConnection();
            } catch (Exception ex) {
                Logger.getLogger(UserBO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return result;
    }

    public List<OrderDTO> GetListAllOrder() {
        List<OrderDTO> list = new ArrayList<>();
        OrderMapper mapper = null;
        try {
            mapper = new OrderMapper();
            list = mapper.GetListAllOrder();
        } catch (Exception ex) {
            Logger.getLogger(UserBO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                mapper.closeConnection();
            } catch (Exception ex) {
                Logger.getLogger(UserBO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return list;
    }

    public List<OrderDTO> searchOrder(String receiver) {
        List<OrderDTO> manufacturers = null;
        OrderMapper mapper = null;
        try {
            mapper = new OrderMapper();
            manufacturers = mapper.searchOrder(receiver);
        } catch (Exception ex) {
            Logger.getLogger(ProductBO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                mapper.closeConnection();
            } catch (Exception ex) {
                Logger.getLogger(ProductBO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return manufacturers;
    }

    public boolean DeleteOrder(int id) {
        boolean result = false;
        OrderMapper mapper = null;
        try {
            mapper = new OrderMapper();
            result = mapper.DeleteOrder(id);
        } catch (Exception ex) {
            Logger.getLogger(OrderBO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                mapper.closeConnection();
            } catch (Exception ex) {
                Logger.getLogger(OrderBO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return result;
    }

    public boolean ConfirmOrder(int id) {
        boolean result = false;
        OrderMapper mapper = null;
        try {
            mapper = new OrderMapper();
            result = mapper.ConfirmOrder(id);
        } catch (Exception ex) {
            Logger.getLogger(OrderBO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                mapper.closeConnection();
            } catch (Exception ex) {
                Logger.getLogger(OrderBO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return result;
    }

    public boolean ThanhToan(int id) {
        boolean result = false;
        OrderMapper mapper = null;
        try {
            mapper = new OrderMapper();
            result = mapper.ThanhToan(id);
        } catch (Exception ex) {
            Logger.getLogger(OrderBO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                mapper.closeConnection();
            } catch (Exception ex) {
                Logger.getLogger(OrderBO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return result;
    }

    public int CountNewOrders() throws NamingException, Exception {
        int count = 0;
        OrderMapper mapper = null;
        try {
            mapper = new OrderMapper();
            count = mapper.CountNewOrders();
        } catch (Exception ex) {
            Logger.getLogger(ProductBO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                mapper.closeConnection();
            } catch (Exception ex) {
                Logger.getLogger(ProductBO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return count;
    }

    public List<OrderDTO> GetListAllNewOrders() throws NamingException, Exception {
        List<OrderDTO> list = new ArrayList<>();
        OrderMapper mapper = null;
        try {
            mapper = new OrderMapper();
            list = mapper.GetListAllNewOrders();
        } catch (Exception ex) {
            Logger.getLogger(UserBO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                mapper.closeConnection();
            } catch (Exception ex) {
                Logger.getLogger(UserBO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return list;
    }
}
