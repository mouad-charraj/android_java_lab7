package com.example.lab7.service;

import com.example.lab7.beans.Star;
import com.example.lab7.dao.IDao;
import java.util.ArrayList;
import java.util.List;

/**
 * Service pour gérer les données des stars Hero 108
 */
public class StarService implements IDao<Star> {
    private List<Star> stars_mouad;
    private static StarService instance_mouad;

    private StarService() {
        stars_mouad = new ArrayList<>();
        remplir_mouad();
    }

    public static StarService getInstance() {
        if (instance_mouad == null) instance_mouad = new StarService();
        return instance_mouad;
    }

    private void remplir_mouad() {
        // Direct image links from Pinimg for all characters
        stars_mouad.add(new Star("Lin Chung", "https://i.pinimg.com/736x/39/17/cb/3917cb16916aab284a4f50344b7544ea.jpg", 5.0f));
        stars_mouad.add(new Star("Mighty Ray", "https://i.pinimg.com/736x/b6/08/b3/b608b3a4f8822e27e359226288e3db4f.jpg", 4.0f));
        stars_mouad.add(new Star("Jumpy Ghostface", "https://i.pinimg.com/736x/a2/7d/43/a27d43709695f92f380f06091ea8ce6e.jpg", 4.2f));
        stars_mouad.add(new Star("Mr. No Hands", "https://i.pinimg.com/736x/0c/39/20/0c3920852781c75b882ffdd9dcb96491.jpg", 3.8f));
        stars_mouad.add(new Star("High Roller", "https://i.pinimg.com/736x/98/f8/27/98f82730b2d361838446bfb3ffc0efaf.jpg", 2.5f));
    }

    @Override public boolean create(Star o_mouad) { return stars_mouad.add(o_mouad); }
    @Override public boolean update(Star o_mouad) {
        for (Star s_mouad : stars_mouad) {
            if (s_mouad.getId() == o_mouad.getId()) {
                s_mouad.setName(o_mouad.getName());
                s_mouad.setImg(o_mouad.getImg());
                s_mouad.setRating(o_mouad.getRating());
                return true;
            }
        }
        return false;
    }
    @Override public boolean delete(Star o_mouad) { return stars_mouad.remove(o_mouad); }
    @Override public Star findById(int id_mouad) {
        for (Star s_mouad : stars_mouad) if (s_mouad.getId() == id_mouad) return s_mouad;
        return null;
    }
    @Override public List<Star> findAll() { return stars_mouad; }
}
