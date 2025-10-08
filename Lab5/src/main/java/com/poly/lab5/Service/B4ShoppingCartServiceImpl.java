package com.poly.lab5.Service;

import com.poly.lab5.dao.B4InterfaceShoppingCartService;
import com.poly.lab5.dao.B4Item;
import com.poly.lab5.db.B5DB;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Service
public class B4ShoppingCartServiceImpl implements B4InterfaceShoppingCartService {
    // Giỏ hàng lưu tạm bằng HashMap (key: id sản phẩm, value: B4Item)
    Map<Integer, B4Item> map = new HashMap<>();

    // 1️⃣ Thêm sản phẩm vào giỏ
    @Override
    public B4Item add(Integer id) {
        B4Item item = B5DB.items.get(id); // B4ItemDAO là nơi chứa danh sách sản phẩm static
        if (item != null) {
            B4Item existing = map.get(id);
            if (existing == null) {
                item.setQty(1);
                map.put(id, item);
            } else {
                existing.setQty(existing.getQty() + 1);
            }
        }
        return map.get(id);
    }

    // 2️⃣ Xóa 1 sản phẩm
    @Override
    public void remove(Integer id) {
        map.remove(id);
    }

    // 3️⃣ Cập nhật số lượng
    @Override
    public B4Item update(Integer id, int qty) {
        B4Item item = map.get(id);
        if (item != null) {
            item.setQty(qty);
        }
        return item;
    }

    // 4️⃣ Xóa toàn bộ giỏ hàng
    @Override
    public void clear() {
        map.clear();
    }

    // 5️⃣ Lấy toàn bộ item trong giỏ
    @Override
    public Collection<B4Item> getItems() {
        return map.values();
    }

    // 6️⃣ Đếm tổng số lượng sản phẩm
    @Override
    public int getCount() {
        return map.values().stream().mapToInt(B4Item::getQty).sum();
    }

    // 7️⃣ Tính tổng tiền
    @Override
    public double getAmount() {
        return map.values().stream()
                .mapToDouble(item -> item.getPrice() * item.getQty())
                .sum();
    }
}
