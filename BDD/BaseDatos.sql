CREATE DATABASE PruebaBanco
GO

USE [PruebaBanco]
GO
/****** Object:  Schema [banco]    Script Date: 10/10/2022 12:40:34 AM ******/
CREATE SCHEMA [banco]
GO
/****** Object:  Table [banco].[Cliente]    Script Date: 10/10/2022 12:40:34 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [banco].[Cliente](
	[clave] [varchar](30) NULL,
	[estado] [varchar](30) NULL,
	[personaId] [bigint] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[personaId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [banco].[Cuenta]    Script Date: 10/10/2022 12:40:34 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [banco].[Cuenta](
	[cuentaId] [bigint] IDENTITY(1,1) NOT NULL,
	[estado] [varchar](50) NOT NULL,
	[numeroCuenta] [varchar](100) NOT NULL,
	[saldoInicial] [numeric](18, 2) NOT NULL,
	[tipoCuenta] [varchar](50) NOT NULL,
	[clienteId] [bigint] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[cuentaId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY],
 CONSTRAINT [UKm09koyl5cv8p27c5gmrk7xk8u] UNIQUE NONCLUSTERED 
(
	[numeroCuenta] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [banco].[Movimientos]    Script Date: 10/10/2022 12:40:34 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [banco].[Movimientos](
	[movimientoId] [bigint] IDENTITY(1,1) NOT NULL,
	[fechaMovimiento] [datetime2](7) NOT NULL,
	[saldo] [numeric](18, 2) NOT NULL,
	[tipoMovimiento] [varchar](50) NOT NULL,
	[valor] [numeric](18, 2) NOT NULL,
	[cuentaId] [bigint] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[movimientoId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [banco].[Persona]    Script Date: 10/10/2022 12:40:34 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [banco].[Persona](
	[personaId] [bigint] IDENTITY(1,1) NOT NULL,
	[direccion] [varchar](10) NOT NULL,
	[edad] [int] NOT NULL,
	[genero] [char](1) NOT NULL,
	[identificacion] [varchar](10) NOT NULL,
	[nombre] [varchar](255) NOT NULL,
	[telefono] [varchar](100) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[personaId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY],
 CONSTRAINT [Persona_UQ001] UNIQUE NONCLUSTERED 
(
	[identificacion] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
ALTER TABLE [banco].[Cliente]  WITH CHECK ADD  CONSTRAINT [FKcq9t9utvkkdq1tl8go7lc646h] FOREIGN KEY([personaId])
REFERENCES [banco].[Persona] ([personaId])
GO
ALTER TABLE [banco].[Cliente] CHECK CONSTRAINT [FKcq9t9utvkkdq1tl8go7lc646h]
GO
ALTER TABLE [banco].[Cuenta]  WITH CHECK ADD  CONSTRAINT [FKiqb8ded52govsq5cqq952m8lf] FOREIGN KEY([clienteId])
REFERENCES [banco].[Cliente] ([personaId])
GO
ALTER TABLE [banco].[Cuenta] CHECK CONSTRAINT [FKiqb8ded52govsq5cqq952m8lf]
GO
ALTER TABLE [banco].[Movimientos]  WITH CHECK ADD  CONSTRAINT [FKa1iu3nr9xaotawmwopmqv2kxb] FOREIGN KEY([cuentaId])
REFERENCES [banco].[Cuenta] ([cuentaId])
GO
ALTER TABLE [banco].[Movimientos] CHECK CONSTRAINT [FKa1iu3nr9xaotawmwopmqv2kxb]
GO
