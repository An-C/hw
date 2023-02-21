package ru.ursip.webservice.edu.demo.entity

import javax.persistence.*

@Entity
@Table(name = "user")
class User(

    @Id
    @SequenceGenerator(name="user-seq", sequenceName="user_id_seq", initialValue=1000, allocationSize=1)
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="user-seq")
    var id: Long = 0L,
    var username: String,
    var firstName: String,
    var lastName: String,
    var email: String,
    var phone: String,
)
