CREATE TABLE [Type] (
[id] INTEGER  NOT NULL PRIMARY KEY AUTOINCREMENT,
[type] nvARCHAR(50)  UNIQUE NOT NULL
);
CREATE TABLE [Manufacturer] (
[id] INTEGER  NOT NULL PRIMARY KEY AUTOINCREMENT,
[manufacturer] nvARCHAR(50)  UNIQUE NOT NULL
);
CREATE TABLE [Produced] (
[id] INTEGER  NOT NULL PRIMARY KEY AUTOINCREMENT,
[produced] nvARCHAR(50)  UNIQUE NOT NULL
);
CREATE TABLE [Variant] (
[id] INTEGER  NOT NULL PRIMARY KEY AUTOINCREMENT,
[variant] nvARCHAR(50)  UNIQUE NOT NULL
);

CREATE TABLE [Weight] (
[id] INTEGER  NOT NULL PRIMARY KEY AUTOINCREMENT,
[weight] nvARCHAR(50)  UNIQUE NOT NULL
);
CREATE TABLE [Length] (
[id] INTEGER  NOT NULL PRIMARY KEY AUTOINCREMENT,
[length] nvARCHAR(50)  UNIQUE NOT NULL
);
CREATE TABLE [BarrelLength] (
[id] INTEGER  NOT NULL PRIMARY KEY AUTOINCREMENT,
[barrellength] nvARCHAR(50)  UNIQUE NOT NULL
);

CREATE TABLE [Caliber] (
[id] INTEGER  NOT NULL PRIMARY KEY AUTOINCREMENT,
[caliber] nvARCHAR(50)  UNIQUE NOT NULL
);
CREATE TABLE [Action] (
[id] INTEGER  NOT NULL PRIMARY KEY AUTOINCREMENT,
[action] nvARCHAR(50)  UNIQUE NOT NULL
);
CREATE TABLE [MuzzleVelocity] (
[id] INTEGER  NOT NULL PRIMARY KEY AUTOINCREMENT,
[muzzlevelocity] nvARCHAR(50)  UNIQUE NOT NULL
);

CREATE TABLE [FeedSystem] (
[id] INTEGER  NOT NULL PRIMARY KEY AUTOINCREMENT,
[feedsystem] nvARCHAR(50)  UNIQUE NOT NULL
);
CREATE TABLE [Sights] (
[id] INTEGER  NOT NULL PRIMARY KEY AUTOINCREMENT,
[sights] NVARCHAR(50)  UNIQUE NOT NULL
);
CREATE TABLE [Country] (
[id] INTEGER  NOT NULL PRIMARY KEY AUTOINCREMENT,
[country] NVARCHAR(30)  UNIQUE NOT NULL
);

CREATE TABLE [Weapon] (
[id] INTEGER  NOT NULL PRIMARY KEY AUTOINCREMENT,
[weapon] NVARCHAR(50)  UNIQUE NOT NULL,
[image] NVARCHAR(50)  UNIQUE NOT NULL,
[info] TEXT  UNIQUE NOT NULL
);

CREATE TABLE [WeaponType] (
[weapon_id] iNTEGER  NOT NULL,
[type_id] INTEGER  NOT NULL,
PRIMARY KEY ([weapon_id],[type_id]),
FOREIGN KEY(weapon_id) REFERENCES Weapon(id),
FOREIGN KEY(type_id) REFERENCES Type(id)
);
CREATE TABLE [WeaponManufacturer] (
[weapon_id] iNTEGER  NOT NULL,
[manufacturer_id] INTEGER  NOT NULL,
PRIMARY KEY ([weapon_id],[manufacturer_id]),
FOREIGN KEY(weapon_id) REFERENCES Weapon(id),
FOREIGN KEY(manufacturer_id) REFERENCES Manufacturer(id)
);
CREATE TABLE [WeaponProduced] (
[weapon_id] INTEGER  NOT NULL,
[produced_id] INTEGER  NOT NULL,
PRIMARY KEY ([weapon_id],[produced_id]),
FOREIGN KEY(weapon_id) REFERENCES Weapon(id),
FOREIGN KEY(produced_id) REFERENCES Produced(id)
);
CREATE TABLE [WeaponVariant] (
[weapon_id] INTEGER  NOT NULL,
[variant_id] INTEGER  NOT NULL,
PRIMARY KEY ([weapon_id],[variant_id]),
FOREIGN KEY(weapon_id) REFERENCES Weapon(id),
FOREIGN KEY(variant_id) REFERENCES Variant(id)
);


CREATE TABLE [WeaponWeight] (
[weapon_id] iNTEGER  NOT NULL,
[weight_id] INTEGER  NOT NULL,
PRIMARY KEY ([weapon_id],[weight_id]),
FOREIGN KEY(weapon_id) REFERENCES Weapon(id),
FOREIGN KEY(weight_id) REFERENCES Weight(id)
);
CREATE TABLE [WeaponLength] (
[weapon_id] INTEGER  NOT NULL,
[length_id] INTEGER  NOT NULL,
PRIMARY KEY ([weapon_id],[length_id]),
FOREIGN KEY(weapon_id) REFERENCES Weapon(id),
FOREIGN KEY(length_id) REFERENCES Length(id)
);
CREATE TABLE [WeaponBarrelLength] (
[weapon_id] INTEGER  NOT NULL,
[barrellength_id] INTEGER  NOT NULL,
PRIMARY KEY ([weapon_id],[barrellength_id]),
FOREIGN KEY(weapon_id) REFERENCES Weapon(id),
FOREIGN KEY(barrellength_id) REFERENCES BarrelLength(id)
);

CREATE TABLE [WeaponCaliber] (
[weapon_id] INTEGER  NOT NULL,
[caliber_id] INTEGER  NOT NULL,
PRIMARY KEY ([weapon_id],[caliber_id]),
FOREIGN KEY(weapon_id) REFERENCES Weapon(id),
FOREIGN KEY(caliber_id) REFERENCES Caliber(id)
);
CREATE TABLE [WeaponAction] (
[weapon_id] iNTEGER  NOT NULL,
[action_id] INTEGER  NOT NULL,
PRIMARY KEY ([weapon_id],[action_id]),
FOREIGN KEY(weapon_id) REFERENCES Weapon(id),
FOREIGN KEY(action_id) REFERENCES Action(id)
);
CREATE TABLE [WeaponMuzzleVelocity] (
[weapon_id] INTEGER  NOT NULL,
[muzzlevelocity_id] INTEGER  NOT NULL,
PRIMARY KEY ([weapon_id],[muzzlevelocity_id]),
FOREIGN KEY(weapon_id) REFERENCES Weapon(id),
FOREIGN KEY(muzzlevelocity_id) REFERENCES MuzzleVelocity(id)
);

CREATE TABLE [WeaponFeedSystem] (
[weapon_id] INTEGER  NOT NULL,
[feedsystem_id] INTEGER  NOT NULL,
PRIMARY KEY ([weapon_id],[feedsystem_id]),
FOREIGN KEY(weapon_id) REFERENCES Weapon(id),
FOREIGN KEY(feedsystem_id) REFERENCES FeedSystem(id)
);
CREATE TABLE [WeaponSights] (
[weapon_id] iNTEGER  NOT NULL,
[sights_id] INTEGER  NOT NULL,
PRIMARY KEY ([weapon_id],[sights_id]),
FOREIGN KEY(weapon_id) REFERENCES Weapon(id),
FOREIGN KEY(sights_id) REFERENCES Sights(id)
);
CREATE TABLE [WeaponCountry] (
[weapon_id] INTEGER  NOT NULL,
[country_id] INTEGER  NOT NULL,
PRIMARY KEY ([weapon_id],[country_id]),
FOREIGN KEY(weapon_id) REFERENCES Weapon(id),
FOREIGN KEY(country_id) REFERENCES Country(id)
);


