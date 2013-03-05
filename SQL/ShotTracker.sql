
CREATE TABLE [Action] (
[id] INTEGER  NOT NULL PRIMARY KEY AUTOINCREMENT,
[action] nvARCHAR(50)  UNIQUE NOT NULL
);

CREATE TABLE [Caliber] (
[id] INTEGER  NOT NULL PRIMARY KEY AUTOINCREMENT,
[caliber] NVARCHAR(50)  UNIQUE NOT NULL

);

CREATE TABLE [Country] (
[id] INTEGER  NOT NULL PRIMARY KEY AUTOINCREMENT,
[country] NVARCHAR(30)  UNIQUE NOT NULL
);

CREATE TABLE [Weapon] (
[id] INTEGER  NOT NULL PRIMARY KEY AUTOINCREMENT,
[weapon] NVARCHAR(50)  UNIQUE NOT NULL
);

CREATE TABLE [WeaponAction] (
[weapon_id] iNTEGER  NOT NULL,
[action_id] INTEGER  NOT NULL,
PRIMARY KEY ([weapon_id],[action_id]),
FOREIGN KEY(weapon_id) REFERENCES Weapon(id),
FOREIGN KEY(action_id) REFERENCES Action(id)
);

CREATE TABLE [WeaponCaliber] (
[weapon_id] INTEGER  NOT NULL,
[caliber_id] INTEGER  NOT NULL,
PRIMARY KEY ([weapon_id],[caliber_id]),
FOREIGN KEY(weapon_id) REFERENCES Weapon(id),
FOREIGN KEY(caliber_id) REFERENCES Caliber(id)
);

CREATE TABLE [WeaponCountry] (
[weapon_id] INTEGER  NOT NULL,
[country_id] INTEGER  NOT NULL,
PRIMARY KEY ([weapon_id],[country_id]),
FOREIGN KEY(weapon_id) REFERENCES Weapon(id),
FOREIGN KEY(country_id) REFERENCES Country(id)
);


