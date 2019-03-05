/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ad04;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

/**
 *
 * @author duche
 */
@Entity
@Table(name = "film", catalog = "sakila", schema = "")
@NamedQueries({
    @NamedQuery(name = "Film_1.findAll", query = "SELECT f FROM Film_1 f")
    , @NamedQuery(name = "Film_1.findByFilmId", query = "SELECT f FROM Film_1 f WHERE f.filmId = :filmId")
    , @NamedQuery(name = "Film_1.findByTitle", query = "SELECT f FROM Film_1 f WHERE f.title = :title")
    , @NamedQuery(name = "Film_1.findByReleaseYear", query = "SELECT f FROM Film_1 f WHERE f.releaseYear = :releaseYear")
    , @NamedQuery(name = "Film_1.findByLanguageId", query = "SELECT f FROM Film_1 f WHERE f.languageId = :languageId")
    , @NamedQuery(name = "Film_1.findByOriginalLanguageId", query = "SELECT f FROM Film_1 f WHERE f.originalLanguageId = :originalLanguageId")
    , @NamedQuery(name = "Film_1.findByRentalDuration", query = "SELECT f FROM Film_1 f WHERE f.rentalDuration = :rentalDuration")
    , @NamedQuery(name = "Film_1.findByRentalRate", query = "SELECT f FROM Film_1 f WHERE f.rentalRate = :rentalRate")
    , @NamedQuery(name = "Film_1.findByLength", query = "SELECT f FROM Film_1 f WHERE f.length = :length")
    , @NamedQuery(name = "Film_1.findByReplacementCost", query = "SELECT f FROM Film_1 f WHERE f.replacementCost = :replacementCost")
    , @NamedQuery(name = "Film_1.findByRating", query = "SELECT f FROM Film_1 f WHERE f.rating = :rating")
    , @NamedQuery(name = "Film_1.findBySpecialFeatures", query = "SELECT f FROM Film_1 f WHERE f.specialFeatures = :specialFeatures")
    , @NamedQuery(name = "Film_1.findByLastUpdate", query = "SELECT f FROM Film_1 f WHERE f.lastUpdate = :lastUpdate")})
public class Film_1 implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "film_id")
    private Short filmId;
    @Basic(optional = false)
    @Column(name = "title")
    private String title;
    @Lob
    @Column(name = "description")
    private String description;
    @Column(name = "release_year")
    @Temporal(TemporalType.DATE)
    private Date releaseYear;
    @Basic(optional = false)
    @Column(name = "language_id")
    private short languageId;
    @Column(name = "original_language_id")
    private Short originalLanguageId;
    @Basic(optional = false)
    @Column(name = "rental_duration")
    private short rentalDuration;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "rental_rate")
    private BigDecimal rentalRate;
    @Column(name = "length")
    private Short length;
    @Basic(optional = false)
    @Column(name = "replacement_cost")
    private BigDecimal replacementCost;
    @Column(name = "rating")
    private String rating;
    @Column(name = "special_features")
    private String specialFeatures;
    @Basic(optional = false)
    @Column(name = "last_update")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastUpdate;

    public Film_1() {
    }

    public Film_1(Short filmId) {
        this.filmId = filmId;
    }

    public Film_1(Short filmId, String title, short languageId, short rentalDuration, BigDecimal rentalRate, BigDecimal replacementCost, Date lastUpdate) {
        this.filmId = filmId;
        this.title = title;
        this.languageId = languageId;
        this.rentalDuration = rentalDuration;
        this.rentalRate = rentalRate;
        this.replacementCost = replacementCost;
        this.lastUpdate = lastUpdate;
    }

    public Short getFilmId() {
        return filmId;
    }

    public void setFilmId(Short filmId) {
        Short oldFilmId = this.filmId;
        this.filmId = filmId;
        changeSupport.firePropertyChange("filmId", oldFilmId, filmId);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        String oldTitle = this.title;
        this.title = title;
        changeSupport.firePropertyChange("title", oldTitle, title);
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        String oldDescription = this.description;
        this.description = description;
        changeSupport.firePropertyChange("description", oldDescription, description);
    }

    public Date getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(Date releaseYear) {
        Date oldReleaseYear = this.releaseYear;
        this.releaseYear = releaseYear;
        changeSupport.firePropertyChange("releaseYear", oldReleaseYear, releaseYear);
    }

    public short getLanguageId() {
        return languageId;
    }

    public void setLanguageId(short languageId) {
        short oldLanguageId = this.languageId;
        this.languageId = languageId;
        changeSupport.firePropertyChange("languageId", oldLanguageId, languageId);
    }

    public Short getOriginalLanguageId() {
        return originalLanguageId;
    }

    public void setOriginalLanguageId(Short originalLanguageId) {
        Short oldOriginalLanguageId = this.originalLanguageId;
        this.originalLanguageId = originalLanguageId;
        changeSupport.firePropertyChange("originalLanguageId", oldOriginalLanguageId, originalLanguageId);
    }

    public short getRentalDuration() {
        return rentalDuration;
    }

    public void setRentalDuration(short rentalDuration) {
        short oldRentalDuration = this.rentalDuration;
        this.rentalDuration = rentalDuration;
        changeSupport.firePropertyChange("rentalDuration", oldRentalDuration, rentalDuration);
    }

    public BigDecimal getRentalRate() {
        return rentalRate;
    }

    public void setRentalRate(BigDecimal rentalRate) {
        BigDecimal oldRentalRate = this.rentalRate;
        this.rentalRate = rentalRate;
        changeSupport.firePropertyChange("rentalRate", oldRentalRate, rentalRate);
    }

    public Short getLength() {
        return length;
    }

    public void setLength(Short length) {
        Short oldLength = this.length;
        this.length = length;
        changeSupport.firePropertyChange("length", oldLength, length);
    }

    public BigDecimal getReplacementCost() {
        return replacementCost;
    }

    public void setReplacementCost(BigDecimal replacementCost) {
        BigDecimal oldReplacementCost = this.replacementCost;
        this.replacementCost = replacementCost;
        changeSupport.firePropertyChange("replacementCost", oldReplacementCost, replacementCost);
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        String oldRating = this.rating;
        this.rating = rating;
        changeSupport.firePropertyChange("rating", oldRating, rating);
    }

    public String getSpecialFeatures() {
        return specialFeatures;
    }

    public void setSpecialFeatures(String specialFeatures) {
        String oldSpecialFeatures = this.specialFeatures;
        this.specialFeatures = specialFeatures;
        changeSupport.firePropertyChange("specialFeatures", oldSpecialFeatures, specialFeatures);
    }

    public Date getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Date lastUpdate) {
        Date oldLastUpdate = this.lastUpdate;
        this.lastUpdate = lastUpdate;
        changeSupport.firePropertyChange("lastUpdate", oldLastUpdate, lastUpdate);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (filmId != null ? filmId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Film_1)) {
            return false;
        }
        Film_1 other = (Film_1) object;
        if ((this.filmId == null && other.filmId != null) || (this.filmId != null && !this.filmId.equals(other.filmId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ad04.Film_1[ filmId=" + filmId + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
